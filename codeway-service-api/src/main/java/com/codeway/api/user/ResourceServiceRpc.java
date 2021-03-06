package com.codeway.api.user;

import com.codeway.FeignClientConfig;
import com.codeway.constant.FeignConst;
import com.codeway.fallback.user.ResourceServiceRpcFallbackFactory;
import com.codeway.pojo.user.Resource;
import com.codeway.utils.JsonData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 资源服务api
 **/

@FeignClient(contextId = "resourceClient",
		value = FeignConst.SERVICE_USER,
		path = FeignConst.SERVICE_RESOURCE_PATH,
		fallbackFactory = ResourceServiceRpcFallbackFactory.class,
		configuration = {FeignClientConfig.class})
public interface ResourceServiceRpc {

	/**
	 * 条件查询资源
	 * @param resource
	 * @return
	 */
	@GetMapping
	JsonData<List<Resource>> findResourceByCondition(Resource resource);

	@GetMapping("/roles")
	JsonData<List<Resource>> findResourceByRoleIds(@RequestParam("roleId") String[] roleIds);
}
