package com.grgbanking.electric.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grgbanking.electric.entity.RecognitionLog;
import com.grgbanking.electric.service.IRecognitionLogService;
import com.grgbanking.electric.param.RecognitionLogQueryParam;

public class RecognitionLogJunitTest extends BaseJunitTest {

	@Autowired
	private IRecognitionLogService recognitionLogService;
	
	@Test
	public void testSaveBatch() {
		List<RecognitionLog> recognitionLogs = new ArrayList<RecognitionLog>();
		for (int i = 10; i < 50; i++) {
			RecognitionLog recognitionLog = new RecognitionLog();
			recognitionLogs.add(recognitionLog);
		}
		recognitionLogService.saveBatch(recognitionLogs);
	}
	
	@Test
	public void testQueryAll() {
		RecognitionLogQueryParam param = new RecognitionLogQueryParam();
		List<RecognitionLog> recognitionLogs = recognitionLogService.queryAll(param);
		for (RecognitionLog recognitionLog : recognitionLogs) {
			System.out.println(recognitionLog.getId());
		}
	}
	
	@Test
	public void testQueryIpaddr() {
	}
}
