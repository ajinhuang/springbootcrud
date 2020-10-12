package com.jin.springcrud.redis.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;

public class JedisConfig {
	@Value("${redis.host}")
	private String host;
	
	@Value("${redis.password}")
	private String password;
	
	@Value("${redis.port}")
	private int port;
	
	@Value("${redis.total}")
	private int total;
	
	@Value("${redis.max-idle}")
	private int maxIdle;
	
	@Value("${redis.min-idle}")
	private int minIdle;
	
	//create client with jedis pool configuration
	@Bean
	public JedisClientConfiguration getJedisClientConfiguration() {
		JedisClientConfiguration.JedisPoolingClientConfigurationBuilder JedisPoolingClientConfigurationBuilder=
				(JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
		GenericObjectPoolConfig GenericObjectPoolConfig= new GenericObjectPoolConfig();
		GenericObjectPoolConfig.setMaxTotal(total);
		GenericObjectPoolConfig.setMaxIdle(maxIdle);
		GenericObjectPoolConfig.setMinIdle(minIdle);
		return JedisPoolingClientConfigurationBuilder.poolConfig(GenericObjectPoolConfig).build();
	}
	
	//create jedis factory
	@Bean
	public JedisConnectionFactory getJedisConnectionFactory() {
		RedisStandaloneConfiguration rdisStandaloneConfiguration= new RedisStandaloneConfiguration();
		rdisStandaloneConfiguration.setHostName(host);
		if(!StringUtils.isEmpty(password)){
			rdisStandaloneConfiguration.setPassword(RedisPassword.of(password));
		}
		rdisStandaloneConfiguration.setPort(port);
		return new JedisConnectionFactory(rdisStandaloneConfiguration, getJedisClientConfiguration());
	}
	
	//create jedis template
	@Bean
	public RedisTemplate redisTemplate() {
		RedisTemplate<String, Object> redisTemplate= new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(getJedisConnectionFactory());
		return redisTemplate;
	}
}
