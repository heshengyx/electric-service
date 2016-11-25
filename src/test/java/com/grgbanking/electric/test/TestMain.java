package com.grgbanking.electric.test;

import com.grgbanking.electric.entity.Role;
import com.grgbanking.electric.util.UUIDGeneratorUtil;

public class TestMain {

	public static void main(String[] args) {
		Role role = new Role();
		role.setId(UUIDGeneratorUtil.getUUID());
		
		//Integer i = 0;
		System.out.println(role.getId().length());
	}

}
