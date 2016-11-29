package com.grgbanking.electric.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.grgbanking.electric.entity.Style;
import com.grgbanking.electric.service.IStyleService;

public class StyleJunitTest extends BaseJunitTest {

	@Autowired
	private IStyleService styleService;
	
	@Test
	public void testSaveBatch() {
		List<Style> styles = new ArrayList<Style>();
		for (int i = 10; i < 50; i++) {
			Style style = new Style();
			styles.add(style);
		}
		styleService.saveBatch(styles);
	}
}
