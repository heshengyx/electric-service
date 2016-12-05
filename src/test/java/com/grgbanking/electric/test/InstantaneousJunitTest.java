package com.grgbanking.electric.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grgbanking.electric.entity.Instantaneous;
import com.grgbanking.electric.service.IInstantaneousService;
import com.grgbanking.electric.util.UUIDGeneratorUtil;

public class InstantaneousJunitTest extends BaseJunitTest {

	@Autowired
	private IInstantaneousService instantaneousService;
	
	@Test
	public void testSaveBatch() {
		List<Instantaneous> instantaneouss = new ArrayList<Instantaneous>();
		for (int i = 1; i < 50; i++) {
			Instantaneous instantaneous = new Instantaneous();
			instantaneous.setId(UUIDGeneratorUtil.getUUID());
			instantaneous.setTerminalId("0791D39DC62043A784F492A4CB399B49");
			instantaneous.setSampleTime(new Date());
			instantaneous.setForwardHas((int)(1+Math.random()*10) * 1000);
			instantaneous.setAssembleHas((int)(1+Math.random()*10) * 1000);
			instantaneous.setReverseHas((int)(1+Math.random()*10) * 1000);
			instantaneous.setAssembleReverseNo((int)(1+Math.random()*10) * 1000);
			instantaneous.setAssembleHas((int)(1+Math.random()*10) * 1000);
			instantaneous.setDegree((int)(1+Math.random()*10) * 1000);
			instantaneous.setCreateBy("admin");
			instantaneouss.add(instantaneous);
			
		}
		instantaneousService.saveBatch(instantaneouss);
	}
	
	public static void main(String[] args) {
		for (int i=0;i<30;i++)
		{System.out.println((int)(1+Math.random()*10) * 1000);}
	}
}
