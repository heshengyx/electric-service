package com.grgbanking.electric.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.grgbanking.electric.dao.ITerminalDao;
import com.grgbanking.electric.entity.Terminal;
import com.grgbanking.electric.enums.StatusEnum;

@Component("heartbeatTask")
public class HeartbeatTask {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(HeartbeatTask.class);
	
	@Value("${timeout}")
	private String timeout;
	
	@Autowired
	private ITerminalDao terminalDao;
	
	public void job() {
		Terminal terminal = new Terminal();
		terminal.setStatus(String.valueOf(StatusEnum.FAIL.getValue()));
		int count = terminalDao.updateByTimeout(terminal, Integer.parseInt(timeout));
		LOGGER.info("更新断线终端个数[{}]", count);
	}
}
