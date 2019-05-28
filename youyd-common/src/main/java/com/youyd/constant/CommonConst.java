package com.youyd.constant;


/**
 * 公共模块常量
 * @author LGG
 * @create 2019年4月23日22:35:18
 * @version 1.0.0
 */
public final class CommonConst {

	/* 常量禁止实例化 */
	private CommonConst() {
		throw new IllegalStateException("Constant prohibition instantiation!");
	}

	public static final int ADD = 1;
	public static final int DELETE= 2;
	public static final int MODIFY= 3;

	/*超时时间*/
	// 三个月
	public static final Integer TIME_OUT_THREE_MONTHS = 60 * 60 * 24 * 30 * 3;
	// 一周
	public static final Integer TIME_OUT_WEEK = 60 * 60 * 24 * 7;
	// 一天
	public static final Integer TIME_OUT_DAY = 60 * 60 * 24;
}