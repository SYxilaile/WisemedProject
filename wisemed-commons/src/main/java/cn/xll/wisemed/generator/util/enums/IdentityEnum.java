package cn.xll.wisemed.generator.util.enums;

/**
 * <b>系统人员身份枚举信息</b>
 */
public enum IdentityEnum {
	IDENTITY_ADMIN(EnumConstans.IDENTITY_ADMIN,"行政"),
	IDENTITY_DOCTOR(EnumConstans.IDENTITY_DOCTOR,"医生"),
	IDENTITY_NURSE(EnumConstans.IDENTITY_NUESR,"护士")
	;
	private String code;                //编码
	private String remark;              //说明

	private IdentityEnum(String code,String remark){
		this.code = code;
		this.remark = remark;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
