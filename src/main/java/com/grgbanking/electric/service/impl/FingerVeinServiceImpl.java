package com.grgbanking.electric.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.grg.recognition.finger.jni.GRGFingerRecognitionJNI;
import com.grgbanking.electric.dao.IEmployeeDao;
import com.grgbanking.electric.dao.IFingerVeinDao;
import com.grgbanking.electric.dao.IRecognitionLogDao;
import com.grgbanking.electric.data.EmployeeData;
import com.grgbanking.electric.data.FingerVeinData;
import com.grgbanking.electric.entity.FingerVein;
import com.grgbanking.electric.entity.RecognitionLog;
import com.grgbanking.electric.enums.OptEnum;
import com.grgbanking.electric.enums.StatusEnum;
import com.grgbanking.electric.page.IPage;
import com.grgbanking.electric.page.IPagination;
import com.grgbanking.electric.page.Pager;
import com.grgbanking.electric.param.FingerVeinQueryParam;
import com.grgbanking.electric.service.IFingerVeinService;
import com.grgbanking.electric.util.ListUtil;
import com.grgbanking.electric.util.UUIDGeneratorUtil;

@Service("fingerVeinService")
public class FingerVeinServiceImpl implements IFingerVeinService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FingerVeinServiceImpl.class);

	private static final int TEMPLATE_SIZE = 1000; // 特征值组大小
	private static final int TEMPLATE_NUM = 3; // 特征值个数
	private static final int TEMPLATE_LENGTH = 6001; // 特征值长度
	private List<FingerVein> fingerVeins = new ArrayList<FingerVein>();

	@Value("${fingervein.threshold}")
	private String threshold;
	
	@Autowired
	private IFingerVeinDao fingerVeinDao;

	@Autowired
	private IEmployeeDao employeeDao;
	
	@Autowired
	private IRecognitionLogDao recognitionLogDao;

	@PostConstruct
	public void init() {
		int count = 0;
		LOGGER.info("指静脉信息开始加载中...");
		try {
			synchronized (this) {
				FingerVeinQueryParam param = new FingerVeinQueryParam();
				param.setStatus(String.valueOf(StatusEnum.SUCCESS.getValue()));
				fingerVeins = fingerVeinDao.queryAll(param);
				count = fingerVeins.size();
				createTemplates(count);
			}
		} catch (Exception e) {
			count = 0;
			LOGGER.info("指静脉信息加载出错", e);
		}
		LOGGER.info("指静脉信息开始加载完成，共加载到[" + count + "]条指纹信息");
	}

	@Override
	public void save(FingerVein fingerVein) {
		fingerVein.setId(UUIDGeneratorUtil.getUUID());
		fingerVein.setCreateTime(new Date());

		int count = fingerVeinDao.save(fingerVein);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
	}

	@Override
	public void saveBatch(List<FingerVein> fingerVeins) {
		FingerVein fingerVein = null;
		for (int i = 0; i < fingerVeins.size(); i++) {
			fingerVein = fingerVeins.get(i);
			fingerVein.setId(UUIDGeneratorUtil.getUUID());
			fingerVein.setCreateTime(new Date());
			fingerVeins.set(i, fingerVein);
		}
		int count = fingerVeinDao.saveBatch(fingerVeins);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据保存失败");
		}
	}

	@Override
	public void saveBatchData(FingerVeinData data) {

	}

	@Override
	public void update(FingerVein fingerVein) {
		fingerVein.setUpdateTime(new Date());
		int count = fingerVeinDao.update(fingerVein);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据修改失败");
		}
	}

	@Override
	public void deleteById(String id) {
		if (!StringUtils.isEmpty(id)) {
			int count = fingerVeinDao.deleteById(id);
			if (count == 0) {
				throw new DataAccessResourceFailureException("数据删除失败");
			}
		} else {
			throw new DataAccessResourceFailureException("数据删除失败");
		}
	}

	@Override
	public void deleteByIds(List<String> ids) {
		if (!CollectionUtils.isEmpty(ids)) {
			int count = fingerVeinDao.deleteByIds(ids);
			if (count == 0) {
				throw new DataAccessResourceFailureException("数据删除失败");
			}
		} else {
			throw new DataAccessResourceFailureException("数据删除失败");
		}
	}

	@Override
	public void delete(FingerVein fingerVein) {
		int count = fingerVeinDao.delete(fingerVein);
		if (count == 0) {
			throw new DataAccessResourceFailureException("数据删除失败");
		}
	}

	@Override
	public FingerVein getById(String id) {
		return fingerVeinDao.getById(id);
	}

	@Override
	public FingerVein getData(FingerVein fingerVein) {
		return fingerVeinDao.getData(fingerVein);
	}

	@Override
	public void saveOrUpdate(FingerVein fingerVein) {
		if (StringUtils.isEmpty(fingerVein.getId())) {
			save(fingerVein);
		} else {
			update(fingerVein);
		}
	}

	@Override
	public IPage<FingerVein> query(final FingerVeinQueryParam param) {
		int page = param.getPage() <= 0 ? 1 : param.getPage();
		int rows = param.getRows() <= 0 ? 10 : param.getRows();
		return Pager.execute(new IPagination<FingerVein>() {

			@Override
			public int count() {
				return fingerVeinDao.count(param);
			}

			@Override
			public List<FingerVein> query(int start, int end) {
				return fingerVeinDao.query(param, start, end);
			}
		}, page, rows);
	}

	@Override
	public List<FingerVein> queryAll(FingerVeinQueryParam param) {
		return fingerVeinDao.queryAll(param);
	}

	/**
	 * 创建特征模板
	 * 
	 * @param count
	 */
	private void createTemplates(int count) {
		int size = count % 1000;
		if (size > 0 && size < 3) {
			// 如果小于3条，补充3条模板
			for (int i = 0; i < 3; i++) {
				fingerVeins.add(fingerVeins.get(0));
			}
		}
	}

	/**
	 * 指静脉识别
	 * 
	 * @param sample
	 * @param template
	 * @param size
	 * @return
	 */
	private int[] recognition(byte[] feature, byte[] template, int size) {
		int[] index = new int[] { 0 };
		int[] statusNum = new int[] { 0 };
		int[] similarity = new int[] { 0 };
		int[] modelNum = new int[] { size };

		GRGFingerRecognitionJNI.GRGRecognition(feature, template, modelNum, index, similarity, statusNum);
		return new int[] { similarity[0], index[0] };
	}

	@Override
	public void register(FingerVein fingerVein) {
		save(fingerVein);
		// 指静脉信息新增时，在内存中也新增一条
		synchronized (this) {
			fingerVeins.add(fingerVein);
			createTemplates(fingerVeins.size());
		}
	}

	@Override
	public String recognition(FingerVein fingerVein, String ipaddr) {
		float threshold = Float.parseFloat(this.threshold);
		LOGGER.info("指静脉特征值阀值：" + threshold);
		LOGGER.info("指静脉识别开始");
		long startTime = System.currentTimeMillis(); // 获取开始时间
		int[] results = new int[] { 0, 0 }; // 识别结果
		int index = 0;

		byte[] destFeatures = new byte[TEMPLATE_SIZE * TEMPLATE_NUM * TEMPLATE_LENGTH];
		synchronized (this) {
			List<List<FingerVein>> fingerVeinList = ListUtil.splitList(fingerVeins, TEMPLATE_SIZE);
			for (List<FingerVein> list : fingerVeinList) {
				int i = 0;
				int length = 0;
				for (FingerVein fVein : list) {
					byte[] srcFeatures = fVein.getFeature();
					length += srcFeatures.length;
					if (i > 0) {
						System.arraycopy(srcFeatures, 0, destFeatures, length - srcFeatures.length, srcFeatures.length);
					} else {
						System.arraycopy(srcFeatures, 0, destFeatures, 0, srcFeatures.length);
					}
					i++;
				}
				results = recognition(fingerVein.getFeature(), destFeatures, list.size());
				if (Float.parseFloat(String.valueOf(results[0])) > threshold && results[1] > -1) {
					index++;
					break;
				} else {
					index++;
				}
			}
		}
		LOGGER.info("指静脉识别结束，执行时间： " + (System.currentTimeMillis() - startTime) + "ms");
		LOGGER.info("指静脉识别相似度：" + results[0] + "，索引：" + results[1]);

		StringBuilder message = new StringBuilder("");
		FingerVein fVein = fingerVeins.get((index - 1) * TEMPLATE_SIZE + results[1]);
		String employeeId = fVein.getEmployeeId();
		EmployeeData employee = employeeDao.getDataById(employeeId);
		message.append(employee.getName()).append("=").append(employee.getCode()).append("=").append(fVein.getSeq())
				.append("=").append(results[0]).append("=");

		RecognitionLog recognitionLog = new RecognitionLog();
		recognitionLog.setId(UUIDGeneratorUtil.getUUID());
		recognitionLog.setName(employee.getName());
		recognitionLog.setCode(employee.getCode());
		recognitionLog.setSeq(fVein.getSeq());
		recognitionLog.setThreshold(String.valueOf(results[0]));
		recognitionLog.setIndexed(results[1]);
		recognitionLog.setOrgName(employee.getOrgName());
		recognitionLog.setIpaddr(ipaddr);
		//recognitionLog.setTerminalId(terminalId);
		recognitionLog.setEmployeeId(employeeId);
		recognitionLog.setFingerveinId(fVein.getId());
		recognitionLog.setCreateTime(new Date());
		recognitionLog.setCreateBy(OptEnum.SYSTEM.name().toLowerCase());
		if (Float.parseFloat(String.valueOf(results[0])) > threshold && results[1] > -1) {
			// 识别通过
			message.append(String.valueOf(StatusEnum.SUCCESS.getValue()));
			if (!StringUtils.isEmpty(employee.getOrgName())) {
				message.append("=").append(employee.getOrgName());
			}
			recognitionLog.setStatus(String.valueOf(StatusEnum.SUCCESS.getValue()));
		} else {
			LOGGER.info("识别失败");
			message.append(String.valueOf(StatusEnum.FAIL.getValue()));
			recognitionLog.setStatus(String.valueOf(StatusEnum.FAIL.getValue()));
		}
		try {
			recognitionLogDao.save(recognitionLog);
		} catch (Exception e) {
			LOGGER.error("识别日志保存失败", e);
		}
		return message.toString();
	}

}