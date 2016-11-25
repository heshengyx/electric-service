package com.grgbanking.electric.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.grgbanking.electric.entity.User;

public interface IUserMapper {

	int save(@Param("param") User user);
	int saveBatch(@Param("list") List<User> users);
	User getUserByAccount(@Param("account") String account);
}
