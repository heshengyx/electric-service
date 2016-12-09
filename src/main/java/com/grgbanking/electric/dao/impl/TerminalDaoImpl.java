package com.grgbanking.electric.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grgbanking.electric.dao.ITerminalDao;
import com.grgbanking.electric.entity.Terminal;
import com.grgbanking.electric.mapper.ITerminalMapper;
import com.grgbanking.electric.param.TerminalQueryParam;


@Repository
public class TerminalDaoImpl implements ITerminalDao {

    @Autowired
    private ITerminalMapper terminalMapper;
    
    @Override
    public int save(Terminal terminal) {
        return terminalMapper.save(terminal);
    }

    @Override
    public int saveBatch(List<Terminal> terminals) {
        return terminalMapper.saveBatch(terminals);
    }
    
    @Override
    public int update(Terminal terminal) {
        return terminalMapper.update(terminal);
    }
    
    @Override
	public int updateByIds(Terminal terminal, List<String> ids) {
		return terminalMapper.updateByIds(terminal, ids);
	}

    @Override
    public int deleteById(String id) {
        return terminalMapper.deleteById(id);
    }

    @Override
    public int delete(Terminal terminal) {
        return terminalMapper.delete(terminal);
    }
    
    @Override
    public int deleteByIds(List<String> ids) {
        return terminalMapper.deleteByIds(ids);
    }

    @Override
    public Terminal getById(String id) {
        return terminalMapper.getById(id);
    }

    @Override
    public Terminal getData(Terminal terminal) {
        return terminalMapper.getData(terminal);
    }

    @Override
    public int count(TerminalQueryParam param) {
        return terminalMapper.count(param);
    }

    @Override
    public List<Terminal> query(TerminalQueryParam param, int start,
            int end) {
        return terminalMapper.query(param, start, end);
    }
    
    @Override
    public int countData(TerminalQueryParam param) {
        return terminalMapper.countData(param);
    }

    @Override
    public List<Terminal> queryData(TerminalQueryParam param, int start,
            int end) {
        return terminalMapper.queryData(param, start, end);
    }

    @Override
    public List<Terminal> queryAll(TerminalQueryParam param) {
        return terminalMapper.queryAll(param);
    }

	@Override
	public List<Terminal> queryByUserId(String userId) {
		return terminalMapper.queryByUserId(userId);
	}
}
