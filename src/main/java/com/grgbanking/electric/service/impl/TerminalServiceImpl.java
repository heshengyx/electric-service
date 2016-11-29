package com.grgbanking.electric.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.grgbanking.electric.dao.ITerminalDao;
import com.grgbanking.electric.data.TerminalData;
import com.grgbanking.electric.entity.Terminal;
import com.grgbanking.electric.page.IPage;
import com.grgbanking.electric.page.IPagination;
import com.grgbanking.electric.page.Pager;
import com.grgbanking.electric.param.TerminalQueryParam;
import com.grgbanking.electric.service.ITerminalService;
import com.grgbanking.electric.util.UUIDGeneratorUtil;


@Service("terminalService")
public class TerminalServiceImpl implements ITerminalService {

    @Autowired
    private ITerminalDao terminalDao;
    
    @Override
    public void save(Terminal terminal) {
        String name = terminal.getName();
if (StringUtils.isEmpty(name)) {
throw new DataAccessResourceFailureException("终端名称不能为空");
}

        terminal.setId(UUIDGeneratorUtil.getUUID());
        terminal.setCreateTime(new Date());
        
        int count = terminalDao.save(terminal);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据保存失败");
        }
    }

    @Override
    public void saveBatch(List<Terminal> terminals) {
        Terminal terminal = null;
        for (int i = 0; i < terminals.size(); i++) {
            terminal = terminals.get(i);
            terminal.setId(UUIDGeneratorUtil.getUUID());
            terminal.setCreateTime(new Date());
            terminals.set(i, terminal);
        }
        int count = terminalDao.saveBatch(terminals);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据保存失败");
        }
    }
    
    @Override
    public void saveBatchData(TerminalData data) {
                List<Terminal> terminals = new ArrayList<Terminal>();
        Terminal terminal = null;
        String[] names = data.getName();
String[] codes = data.getCode();
String[] styleIds = data.getStyleId();

        for (int i = 0; i < names.length; i++) {
            terminal = new Terminal();
            terminal.setId(UUIDGeneratorUtil.getUUID());
            terminal.setName(names[i]);
terminal.setCode(codes[i]);
terminal.setStyleId(styleIds[i]);

            terminal.setCreateTime(new Date());
            terminal.setCreateBy(data.getCreateBy());
            terminals.add(terminal);
        }
        int count = terminalDao.saveBatch(terminals);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据保存失败");
        }        //
    }
    
    @Override
    public void update(Terminal terminal) {
        String name = terminal.getName();
if (StringUtils.isEmpty(name)) {
throw new DataAccessResourceFailureException("终端名称不能为空");
}

        terminal.setUpdateTime(new Date());
        int count = terminalDao.update(terminal);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据修改失败");
        }
    }

    @Override
    public void deleteById(String id) {
        if (!StringUtils.isEmpty(id)) {
            int count = terminalDao.deleteById(id);
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
            int count = terminalDao.deleteByIds(ids);
            if (count == 0) {
                throw new DataAccessResourceFailureException("数据删除失败");
            }
        } else {
            throw new DataAccessResourceFailureException("数据删除失败");
        }
    }

    @Override
    public void delete(Terminal terminal) {
        int count = terminalDao.delete(terminal);
        if (count == 0) {
            throw new DataAccessResourceFailureException("数据删除失败");
        }
    }

    @Override
    public Terminal getById(String id) {
        return terminalDao.getById(id);
    }

    @Override
    public Terminal getData(Terminal terminal) {
        return terminalDao.getData(terminal);
    }
    
    @Override
    public void saveOrUpdate(Terminal terminal) {
        if (StringUtils.isEmpty(terminal.getId())) {
            save(terminal);
        } else {
            update(terminal);
        }
    }

    @Override
    public IPage<Terminal> query(final TerminalQueryParam param) {
        int page = param.getPage() <= 0 ? 1 : param.getPage();
        int rows = param.getRows() <= 0 ? 10 : param.getRows();
        return Pager.execute(new IPagination<Terminal>() {

            @Override
            public int count() {
                return terminalDao.count(param);
            }

            @Override
            public List<Terminal> query(int start, int end) {
                return terminalDao.query(param, start, end);
            }
        }, page, rows);
    }
    
    @Override
	public List<Terminal> queryAll(TerminalQueryParam param) {
		return terminalDao.queryAll(param);
	}
}