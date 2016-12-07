package com.grgbanking.electric.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grgbanking.electric.entity.Curve;
import com.grgbanking.electric.param.CurveQueryParam;
import com.grgbanking.electric.service.ICurveService;
import com.grgbanking.electric.util.UUIDGeneratorUtil;

public class CurveJunitTest extends BaseJunitTest {

	@Autowired
	private ICurveService curveService;
	
	@Test
	public void testSaveBatch() {
		List<Curve> curves = new ArrayList<Curve>();
		for (int i = 10; i < 50; i++) {
			Curve curve = new Curve();
			curve.setId(UUIDGeneratorUtil.getUUID());
			curve.setTerminalId("0791D39DC62043A784F492A4CB399B49");
			curve.setSampleTime(new Date());
			curve.setAssembleHas((int)(1+Math.random()*10) * 1000);
			curve.setAssembleNo((int)(1+Math.random()*10) * 1000);
			curve.setTotals((int)(1+Math.random()*10) * 1000);
			curve.setForwardHas((int)(1+Math.random()*10) * 1000);
			curve.setForwardNo((int)(1+Math.random()*10) * 1000);
			curve.setReverseHas((int)(1+Math.random()*10) * 1000);
			curve.setReverseNo((int)(1+Math.random()*10) * 1000);
			curve.setCreateBy("admin");
			curves.add(curve);
		}
		curveService.saveBatch(curves);
	}
	
	@Test
	public void testQueryAll() {
		CurveQueryParam param = new CurveQueryParam();
		List<Curve> curves = curveService.queryAll(param);
		for (Curve curve : curves) {
			System.out.println(curve.getId());
		}
	}
}
