package com.grgbanking.electric.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grgbanking.electric.entity.Event;
import com.grgbanking.electric.service.IEventService;
import com.grgbanking.electric.util.UUIDGeneratorUtil;
import com.grgbanking.electric.param.EventQueryParam;

public class EventJunitTest extends BaseJunitTest {

	@Autowired
	private IEventService eventService;
	
	@Test
	public void testSaveBatch() {
		List<Event> events = new ArrayList<Event>();
		for (int i = 10; i < 50; i++) {
			Event event = new Event();
			event.setId(UUIDGeneratorUtil.getUUID());
			event.setTerminalId("0791D39DC62043A784F492A4CB399B49");
			event.setName("事件" + i);
			event.setCode("100" + i);
			event.setCreateBy("admin");
			events.add(event);
		}
		eventService.saveBatch(events);
	}
	
	@Test
	public void testQueryAll() {
		EventQueryParam param = new EventQueryParam();
		List<Event> events = eventService.queryAll(param);
		for (Event event : events) {
			System.out.println(event.getId());
		}
	}
}
