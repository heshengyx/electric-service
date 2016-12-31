package com.grgbanking.electric.dao.redis.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.grgbanking.electric.dao.IUserDao;
import com.grgbanking.electric.entity.User;
import com.grgbanking.electric.param.UserQueryParam;
import com.grgbanking.electric.transcoder.ListTranscoder;
import com.grgbanking.electric.transcoder.ObjectsTranscoder;

@Repository
public class UserDaoImpl extends RedisBaseDao<String, User> implements IUserDao {

	@Override
	public int save(final User user) {
		/*boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				//byte[] key = serializer.serialize(user.getId());
				//byte[] name = serializer.serialize(user.getName());
				
				byte[] key = user.getId().getBytes();
				byte[] name = SerializationUtil.serialize(user);
				return connection.setNX(key, name);
			}
		});*/
		ValueOperations<String, User> valueOpt = redisTemplate.opsForValue();
		valueOpt.set(user.getId(), user);
		return 0;
	}

	@Override
	public int saveBatch(final List<User> users) {
		/*boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				//ObjectsTranscoder<User> serializer = new ObjectsTranscoder<User>();
				//RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = "zhangsan".getBytes();
				for (User user : users) {
					System.out.println(user.getName());
				}
				//byte[] name = serializer.serialize(users);
				byte[] name = ListTranscoder.serialize(users);
				return connection.setNX(key, name);
			}
		});*/
		ListOperations<String, User> valueOpt = redisTemplate.opsForList();
		return 0;
	}

	@Override
	public int update(User user) {
		return 0;
	}

	@Override
	public int deleteById(String id) {
		return 0;
	}

	@Override
	public int delete(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByIds(List<String> ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getById(final String id) {
		/*return redisTemplate.execute(new RedisCallback<User>() {
			public User doInRedis(RedisConnection connection)
					throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				//byte[] key = serializer.serialize(id);
				byte[] value = connection.get(key);
				if (value == null) {
					return null;
				}
				String name = serializer.deserialize(value);
				User user = new User();
				user.setId(id);
				user.setName(name);
				byte[] key = id.getBytes();
				User user = (User) SerializationUtil.deserialize(key);
				return user;
			}
		});*/
		ValueOperations<String, User> valueOpt = redisTemplate.opsForValue();
		return valueOpt.get(id);
	}

	@Override
	public User getData(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(UserQueryParam param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> query(UserQueryParam param, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> queryAll(UserQueryParam param) {
		ObjectsTranscoder<User> serializer = new ObjectsTranscoder<User>();
		byte[] key = "zhangsan".getBytes();
		List<User> list = (List<User>) ListTranscoder.deserialize(key);
		return list;
	}

}
