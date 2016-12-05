package com.grgbanking.electric.test;

import java.util.HashMap;
import java.util.Map;

import com.grgbanking.electric.entity.Role;
import com.grgbanking.electric.tree.Tree;
import com.grgbanking.electric.util.UUIDGeneratorUtil;

public class TestMain {

	public static void main(String[] args) {
		/*Role role = new Role();
		role.setId(UUIDGeneratorUtil.getUUID());
		
		//Integer i = 0;
		System.out.println(role.getId().length());*/
		
		Map<String, String> attributes = new HashMap<String, String>(1);
		attributes.put("isTerminal", "true");
		attributes.put("code", "131331");
		for (Map.Entry<String, String> entry : attributes.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

}
