package com.youyd.enums;

/**
 * 状态码定义
 * @author : LGG
 * @create : 2018-09-26 14:34
 **/
public enum StatusEnum {

	/* 系统ERROR */
	UNKNOWN(-1,"系统错误"),


	OK(20000,"操作成功！"), //成功
	ERROR(20001,"操作失败！"), // error
	SYSTEM_EXCEPTION(0,"系统异常！"), // 系统异常
	LOGIN_ERROR(20002,"用户名或密码错误！"),// Login error
	UN_AUTHORIZED(20003,"权限不足！"),// 权限不足 Access error
	RPC_ERROR(20004,"远程调用失败！"),// 远程调用失败 Remote Procedure Call error
	PARAM_ILLEGAL(20006,"参数不正确！"),
	PARAM_MISSING(20007,"缺少请求参数！"),
	PARAM_INVALID(20008,"参数校验失败！"),
	REQUEST_ERROR(20009,"请求格式错误！"),
	SYSTEM_ERROR(20010,"系统异常！"),
	SERVICE_OFF(20011,"服务已下线或未注册！"),
	LOGIN_EXPIRED(20012,"登录已失效，请重新登录！"),



	/* 认证，权限 */

	INVALID_REQUEST(40001, "无效请求"),
	INVALID_CLIENT(40002, "无效client_id"),
	INVALID_GRANT(40003, "无效授权"),
	INVALID_SCOPE(40004, "无效scope"),
	INVALID_TOKEN(40005, "无效token"),
	INSUFFICIENT_SCOPE(40010, "授权不足"),
	REDIRECT_URI_MISMATCH(40020, "redirect url不匹配"),
	ACCESS_DENIED(40030, "拒绝访问"),
	METHOD_NOT_ALLOWED(40040, "不支持该方法"),
	SERVER_ERROR(40050, "权限服务错误"),
	UNAUTHORIZED_CLIENT(40060, "未授权客户端"),
	UNAUTHORIZED(40061, "未授权"),
	UNSUPPORTED_RESPONSE_TYPE(40070, " 支持的响应类型"),
	UNSUPPORTED_GRANT_TYPE(40071, "不支持的授权类型");

	private Integer code;
	private String msg;
	public Integer getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	StatusEnum() {
	}
	// 枚举中使用的值需要在构造函数中定义
	StatusEnum(Integer code, String msg){
		this.code = code;
		this.msg = msg;
	}
}
