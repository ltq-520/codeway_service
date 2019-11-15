/*
package com.ibole.gateway.handle;

import com.ibole.enums.StatusEnum;
import com.ibole.pojo.ErrotResult;
import com.ibole.utils.JsonUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

*/
/**
 * 用户登录失败时返回给前端的数据
 **//*


@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
		ErrotResult errotResult = new ErrotResult(StatusEnum.ERROR);
		httpServletResponse.getWriter().write(JsonUtil.toJsonString(errotResult));
	}
}
*/
