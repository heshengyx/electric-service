package com.grgbanking.electric.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grgbanking.electric.entity.Terminal;
import com.grgbanking.electric.param.TerminalQueryParam;
import com.grgbanking.electric.service.ITerminalService;

public class TerminalJunitTest extends BaseJunitTest {

	@Autowired
	private ITerminalService terminalService;
	
	@Test
	public void testSaveBatch() {
		List<Terminal> terminals = new ArrayList<Terminal>();
		for (int i = 10; i < 50; i++) {
			Terminal terminal = new Terminal();
			terminals.add(terminal);
		}
		terminalService.saveBatch(terminals);
	}
	
	@Test
	public void testQueryAll() {
		TerminalQueryParam param = new TerminalQueryParam();
		List<Terminal> terminals = terminalService.queryAll(param);
		for (Terminal terminal : terminals) {
			System.out.println(terminal.getId());
		}
	}
}
