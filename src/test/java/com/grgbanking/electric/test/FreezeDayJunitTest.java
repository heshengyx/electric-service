package com.grgbanking.electric.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grgbanking.electric.entity.FreezeDay;
import com.grgbanking.electric.service.IFreezeDayService;
import com.grgbanking.electric.util.UUIDGeneratorUtil;
import com.grgbanking.electric.param.FreezeDayQueryParam;

public class FreezeDayJunitTest extends BaseJunitTest {

	@Autowired
	private IFreezeDayService freezeDayService;
	
	@Test
	public void testSaveBatch() {
		List<FreezeDay> freezeDays = new ArrayList<FreezeDay>();
		for (int i = 10; i < 50; i++) {
			FreezeDay freezeDay = new FreezeDay();
			freezeDay.setId(UUIDGeneratorUtil.getUUID());
			freezeDay.setTerminalId("0791D39DC62043A784F492A4CB399B49");
			freezeDay.setSampleTime(new Date());
			freezeDay.setAssembleTotals((int)(1+Math.random()*10) * 1000);
			freezeDay.setForwardHas((int)(1+Math.random()*10) * 1000);
			freezeDay.setForwardNo((int)(1+Math.random()*10) * 1000);
			freezeDay.setReverseHas((int)(1+Math.random()*10) * 1000);
			freezeDay.setReverseNo((int)(1+Math.random()*10) * 1000);
			freezeDay.setTotals((int)(1+Math.random()*10) * 1000);
			freezeDay.setForwardHasDay((int)(1+Math.random()*10) * 1000);
			freezeDay.setForwardNoDay((int)(1+Math.random()*10) * 1000);
			freezeDay.setReverseHasDay((int)(1+Math.random()*10) * 1000);
			freezeDay.setReverseNoDay((int)(1+Math.random()*10) * 1000);
			freezeDay.setPeakTotals((int)(1+Math.random()*10) * 1000);
			freezeDay.setFlatTotals((int)(1+Math.random()*10) * 1000);
			freezeDay.setValleyTotals((int)(1+Math.random()*10) * 1000);
			freezeDay.setTipTotals((int)(1+Math.random()*10) * 1000);
			freezeDay.setMorningTotals((int)(1+Math.random()*10) * 1000);
			freezeDay.setMiddayTotals((int)(1+Math.random()*10) * 1000);
			freezeDay.setNightTotals((int)(1+Math.random()*10) * 1000);
			freezeDay.setCreateBy("admin");
			freezeDays.add(freezeDay);
		}
		freezeDayService.saveBatch(freezeDays);
	}
	
	@Test
	public void testQueryAll() {
		FreezeDayQueryParam param = new FreezeDayQueryParam();
		List<FreezeDay> freezeDays = freezeDayService.queryAll(param);
		for (FreezeDay freezeDay : freezeDays) {
			System.out.println(freezeDay.getId());
		}
	}
}
