package com.codeway.auth.service;

import com.codeway.api.base.LoginLogServiceRpc;
import com.codeway.db.redis.service.RedisService;
import com.codeway.utils.security.JWTAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 登录，认证
 **/
@Service
public class AuthenticationService {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RedisService redisService;

	@Autowired
	LoginLogServiceRpc loginLogServiceRpc;

    @Autowired
    RestTemplate restTemplate;

	public void logout(String token) {
		String key = "user_token:" + JWTAuthentication.getFullAuthorization(token);
		redisService.del(key);
	}
}
