package com.grgbanking.electric.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import com.grgbanking.electric.dao.redis.impl.UserDaoImpl;
import com.grgbanking.electric.entity.User;

public class RedisTest {

	private ApplicationContext applicationContext;
	private RedisTemplate<String, User> redisTemplate;
	private UserDaoImpl memberDao;

	@SuppressWarnings("unchecked")
	@Before
	public void setup() {
		applicationContext = new ClassPathXmlApplicationContext(
				"classpath*:application-redis.xml");
		redisTemplate = (RedisTemplate<String, User>) applicationContext.getBean("redisTemplate");
		memberDao = new UserDaoImpl();
		memberDao.setRedisTemplate(redisTemplate);
	}
	
	@Test
	public void testAdd() {
		User member = new User();
		member.setId("1");
		member.setName("zhangsan");
		try {
			memberDao.save(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testGet() {
		User member = memberDao.getById("1");
		System.out.println(member.getName());
	}
}
