package cn.xll.wisemed.generator.util.enums;


import java.util.Properties;

/**
 * <b>系统枚举常量信息类</b>
 */
class EnumConstans {
	private static Properties props = new Properties();

	//使用静态代码块加载配置信息
	static {
		try {
			props.load(EnumConstans.class.getClassLoader().getResourceAsStream("props/wisemes/enum.properties"));
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * <b>系统人员身份 - 行政人员</b>
	 */
	static final String IDENTITY_ADMIN = props.getProperty("identity.admin");

	/**
	 * <b>系统人员身份 - 医生</b>
	 */
	static final String IDENTITY_DOCTOR = props.getProperty("identity.doctor");

	/**
	 * <b>系统人员身份 - 护士</b>
	 */
	static final String IDENTITY_NUESR = props.getProperty("identity.nurse");
}
