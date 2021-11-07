package cn.xll.wisemed.generator.base.pojo.enums;

import java.util.Properties;

/**
 * <b>系统基础信息类 - 基础枚举配置常量信息工具类</b>
 */
 class BaseEnumConstants {
	private static Properties props = new Properties();

	//使用静态代码块加载配置信息
	static {
		try {
			props.load(BaseEnumConstants.class.getClassLoader().getResourceAsStream("props/base/enum.properties"));
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * <b>系统状态：启用</b>
	 */
	static final String ENUM_STATUS_ENABLE = props.getProperty("enum.status.enable");

	/**
	 * <b>系统状态：禁用/b>
	 */
	static final String ENUM_STATUS_DISABLE = props.getProperty("enum.status.disable");

	/**
	 * <b>系统响应编码：系统响应成功</b>
	 */
	static final Integer ENUM_RESPONSE_CODE_SUCCESS =Integer.parseInt(props.getProperty("enum.response.code.success"));

	/**
	 * <b>系统响应编码：用户未认证</b>
	 */
	static final Integer ENUM_RESPONSE_CODE_UNAUTH =Integer.parseInt(props.getProperty("enum.response.code.unauth"));

	/**
	 * <b>系统响应编码：系统业务处理错误</b>
	 */
	static final Integer ENUM_RESPONSE_CODE_ERROR =Integer.parseInt(props.getProperty("enum.response.code.error"));

	/**
	 * <b>系统响应编码：系统响应异常</b>
	 */
	static final Integer ENUM_RESPONSE_CODE_EXCEPTION =Integer.parseInt(props.getProperty("enum.response.code.exception"));
}
