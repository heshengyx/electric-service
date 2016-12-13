package com.grgbanking.electric.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grgbanking.electric.entity.FingerVein;
import com.grgbanking.electric.service.IFingerVeinService;
import com.grgbanking.electric.util.BASE64Util;
import com.grgbanking.electric.util.UUIDGeneratorUtil;
import com.grgbanking.electric.param.FingerVeinQueryParam;

public class FingerVeinJunitTest extends BaseJunitTest {

	@Autowired
	private IFingerVeinService fingerVeinService;
	
	@Test
	public void testSaveBatch() {
		List<FingerVein> fingerVeins = new ArrayList<FingerVein>();
		for (int i = 10; i < 50; i++) {
			FingerVein fingerVein = new FingerVein();
			fingerVeins.add(fingerVein);
		}
		fingerVeinService.saveBatch(fingerVeins);
	}
	
	@Test
	public void testQueryAll() {
		FingerVeinQueryParam param = new FingerVeinQueryParam();
		param.setStatus("1");
		List<FingerVein> fingerVeins = fingerVeinService.queryAll(param);
		for (FingerVein fingerVein : fingerVeins) {
			//System.out.println(fingerVein.getId());
			//fingerVein.setId(UUIDGeneratorUtil.getUUID());
			//fingerVeinService.save(fingerVein);
			//String fea = BASE64Util.encode(fingerVein.getFeature());
			//System.out.println(fea.replaceAll("\\s", ""));
			System.out.println(fingerVein.getEmployeeId());
			break;
		}
	}
}
