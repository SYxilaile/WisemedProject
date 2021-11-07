package cn.xll.wisemed.generator.system.user.pojo.vo;

import cn.xll.wisemed.generator.base.pojo.vo.BaseVO;
import cn.xll.wisemed.generator.system.user.pojo.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

/**
 * <b>系统功能模块 - 基础用户视图信息</b>
 * <p>
 *     用于系统行政人员、医生、护士等登录使用
 * </p>
 * @author wang
 * @version 1.0.0
 */
@ApiModel(value = "系统功能模块 - 基础用户视图信息")
public class UserVO extends BaseVO {
	private static final long serialVersionUID = 5478038833586300066L;
	@ApiModelProperty(value = "主键")
	private String id;                //主键
	@ApiModelProperty(value = "姓名")
	private String name ;             //姓名
	@ApiModelProperty(value = "手机号码")
	private String cellphone;         //手机号码
	@ApiModelProperty(value = "登录密码，采用MD5加密")
	private String password;          //登录密码，采用MD5加密
	@ApiModelProperty(value = "身份信息：0-行政人员，1-医生，2-护士")
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
	 * <b>通过将视图对象属性复制到视图对象，并且获得视图对象</b>
	 * @param entity
	 * @return
	 */
	public static UserVO getVOFromEntity(User entity){
		UserVO vo = new UserVO();
		if(entity != null){
			BeanUtils.copyProperties(entity, vo);
		}
		return vo;
	}
}
