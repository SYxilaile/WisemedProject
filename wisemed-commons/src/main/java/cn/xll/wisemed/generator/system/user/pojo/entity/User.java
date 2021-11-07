package cn.xll.wisemed.generator.system.user.pojo.entity;

import cn.xll.wisemed.generator.base.pojo.entity.BaseEntity;
import cn.xll.wisemed.generator.system.user.pojo.vo.UserVO;
import org.springframework.beans.BeanUtils;

/**
 * <b>系统功能模块 - 基础用户实体信息</b>
 * <p>
 *     用于系统行政人员、医生、护士等登录使用
 * </p>
 * @author wang
 * @version 1.0.0
 */
public class User extends BaseEntity {
	private static final long serialVersionUID = -1497201983362317272L;
	private String id;                //主键
	private String name ;             //姓名
	private String cellphone;         //手机号码
	private String password;          //登录密码，采用MD5加密
	private String identity;          //身份信息：0-行政人员，1-医生，2-护士

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	/**
	 * <b>通过将视图对象属性复制到实体对象，并且获得实体对象</b>
	 * @param vo
	 * @return
	 */
	public static User getEntityFromVO(UserVO vo){
		User entity = new User();
		if(vo != null){
			BeanUtils.copyProperties(vo, entity);
		}
		return entity;
	}
}
