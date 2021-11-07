package cn.xll.wisemed.generator.util;

import java.util.Properties;

/**
 * <b>系统常量工具类</b>
 * @author wang
 * @version 1.0.0
 */
public class ConstantsUtil {
	private static Properties props = new Properties();

	//使用静态代码块加载配置信息
	static {
		try {
			props.load(ConstantsUtil.class.getClassLoader().getResourceAsStream("props/wisemed/wisemed.properties"));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * <b>登录有效时间</b>
	 */
	public static final Long LOGIN_EXPIRE_SEC = Long.parseLong(props.getProperty("login.expire.second"));
}
