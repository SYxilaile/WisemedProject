package cn.xll.wisemed.generator.user.controller;

import cn.hutool.core.util.StrUtil;
import cn.xll.wisemed.generator.base.controller.BaseController;
import cn.xll.wisemed.generator.base.pojo.enums.StatusEnum;
import cn.xll.wisemed.generator.base.pojo.vo.ResponseVO;
import cn.xll.wisemed.generator.base.util.MD5Util;
import cn.xll.wisemed.generator.base.util.RedisUtil;
import cn.xll.wisemed.generator.base.util.TokenUtil;
import cn.xll.wisemed.generator.system.user.pojo.vo.LoginUserVO;
import cn.xll.wisemed.generator.system.user.pojo.vo.UserVO;
import cn.xll.wisemed.generator.system.user.transport.UserTransport;
import cn.xll.wisemed.generator.util.ConstantsUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>系统功能模块 - 基础用户控制层</b>
 * @author wang
 * @version 1.0.0
 */
@Api(value = "系统功能模块 - 基础用户控制层",tags = "系统功能模块 - 基础用户控制层")
@RestController("userController")
@RequestMapping("/system/user")
public class UserController extends BaseController {
	@Autowired
	private UserTransport transport;
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * <b>使用登录用户视图对象进行系统登录</b>
	 * @param loginUserVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/login")
	public ResponseVO loginUser(@RequestBody LoginUserVO loginUserVO) throws Exception{
			try {
				//检验用户提交的登录信息是否有效
				if(StrUtil.isBlank(loginUserVO.getCellphone()) && StrUtil.isBlank(loginUserVO.getPassword())){
					//对于登录密码 MD5 加密
					loginUserVO.setPassword(MD5Util.encrypt(loginUserVO.getPassword()));
					//使用手机号码查询用户信息
					UserVO userVO =transport.getUserByCellphone(loginUserVO.getCellphone());
					//比较手机号码和密码是否正确
					if(userVO != null && loginUserVO.getPassword().equals(userVO.getPassword())){
						if(StatusEnum.STATUS_ENABLE.getCode().equals(userVO.getStatus())){
							//用户登录成功，生 Token 信息
							Map<String,Object> infoMap = new HashMap<String,Object>();
							infoMap.put("id",userVO.getId());
							String token = TokenUtil.createToken(infoMap, ConstantsUtil.LOGIN_EXPIRE_SEC);
							//将 Token 作为 key，登录对象作为 value 存储到 Redis 中
							redisUtil.SetToRedis(token, userVO, ConstantsUtil.LOGIN_EXPIRE_SEC);
							//将 Token 携带在响应对象的 Header 中
							response.setHeader("Authorization" , token);
							return ResponseVO.getSuccessResponseVO(userVO);
						}
						return ResponseVO.getErrorResponseVO("该用户禁止登录");
					}
					return ResponseVO.getErrorResponseVO("手机号码或密码错误");
				}
				return ResponseVO.getErrorResponseVO("未填写有效的登录信息");
			}catch(Exception e){
				e.printStackTrace();
				return ResponseVO.getExceptionResponseVO(e);
			}
	}

}
