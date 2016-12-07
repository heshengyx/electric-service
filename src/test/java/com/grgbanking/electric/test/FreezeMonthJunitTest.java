package com.grgbanking.electric.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grgbanking.electric.entity.FreezeMonth;
import com.grgbanking.electric.service.IFreezeMonthService;
import com.grgbanking.electric.util.UUIDGeneratorUtil;
import com.grgbanking.electric.param.FreezeMonthQueryParam;

public class FreezeMonthJunitTest extends BaseJunitTest {

	@Autowired
	private IFreezeMonthService freezeMonthService;
	
	@Test
	public void testSaveBatch() {
		List<FreezeMonth> freezeMonths = new ArrayList<FreezeMonth>();
		for (int i = 10; i < 50; i++) {
			FreezeMonth freezeMonth = new FreezeMonth();
			freezeMonth.setId(UUIDGeneratorUtil.getUUID());
			freezeMonth.setTerminalId("0791D39DC62043A784F492A4CB399B49");
			freezeMonth.setSampleTime(new Date());
			freezeMonth.setAssembleTotals((int)(1+Math.random()*10) * 1000);
			freezeMonth.setForwardHas((int)(1+Math.random()*10) * 1000);
			freezeMonth.setForwardNo((int)(1+Math.random()*10) * 1000);
			freezeMonth.setReverseHas((int)(1+Math.random()*10) * 1000);
			freezeMonth.setReverseNo((int)(1+Math.random()*10) * 1000);
			freezeMonth.setTotals((int)(1+Math.random()*10) * 1000);
			freezeMonth.setForwardHasMonth((int)(1+Math.random()*10) * 1000);
			freezeMonth.setForwardNoMonth((int)(1+Math.random()*10) * 1000);
			freezeMonth.setReverseHasMonth((int)(1+Math.random()*10) * 1000);
			freezeMonth.setReverseNoMonth((int)(1+Math.random()*10) * 1000);
			freezeMonth.setPeakTotals((int)(1+Math.random()*10) * 1000);
			freezeMonth.setFlatTotals((int)(1+Math.random()*10) * 1000);
			freezeMonth.setValleyTotals((int)(1+Math.random()*10) * 1000);
			freezeMonth.setTipTotals((int)(1+Math.random()*10) * 1000);
			freezeMonth.setMorningTotals((int)(1+Math.random()*10) * 1000);
			freezeMonth.setMiddayTotals((int)(1+Math.random()*10) * 1000);
			freezeMonth.setNightTotals((int)(1+Math.random()*10) * 1000);
			freezeMonth.setCreateBy("admin");
			freezeMonths.add(freezeMonth);
		}
		freezeMonthService.saveBatch(freezeMonths);
	}
	
	@Test
	public void testQueryAll() {
		FreezeMonthQueryParam param = new FreezeMonthQueryParam();
		List<FreezeMonth> freezeMonths = freezeMonthService.queryAll(param);
		for (FreezeMonth freezeMonth : freezeMonths) {
			System.out.println(freezeMonth.getId());
		}
	}
}
