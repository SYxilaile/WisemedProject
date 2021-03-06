package cn.xll.wisemed.generator.base.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>系统基础信息类 - 用户 Token 工具类</b>
 * @author wang
 * @version 1.0.0
 * @since 1.0.0
 */
public class TokenUtil {
	//设置加密 Token 所使用的的算法
	private static final Algorithm ALGORITHM = Algorithm.HMAC256(BaseConstants.SECRET_KEY);

	/**
	 * <b>使用用户主键生成 Token 信息</b>
	 * @param infoMap
	 * @param expireTimeSeconds
	 * @return
	 */
	public static String createToken(Map<String,Object> infoMap,Long expireTimeSeconds){
		//创建生成 Token 对象
		JWTCreator.Builder builder = JWT.create();
		//一个完整 Token 包括三部分：
		//签名信息，包括：算法和相关信息
		Map<String,Object> header = new HashMap<String,Object>();
		//设置信息为 JWT 所生成的
		header.put("typ", "jwt");
		//设置加密所使用的的算法为 HS256
		header.put("alg","HS256");
		//将头部信息设置到 Token 中
		builder.withHeader(header);
		//2、有效载荷，可以将相关信息保存到 Token 中，在校验解密时，可以获得该信息
		//将用户的主键增加到有效载荷中
		//循环 Map 集合,将其中的数据进行设定
		//获得所有的 key，变成 set 集合
		builder.withClaim("message", infoMap);
		//设置 Token 的过期时间
		if(expireTimeSeconds == null || expireTimeSeconds < 0){
			//用户所设定的时间无效
			expireTimeSeconds = BaseConstants.EXPIRE_SECOND;
		}
		Long expireTimeMillis = new Date().getTime() + expireTimeSeconds * 1000;
		//根据过期毫秒数，获得对应的 java.util.Date 对象
		Date expireDate = new Date(expireTimeMillis);
		//设置过期时间
		builder.withExpiresAt(expireDate);
		//3.进行 Token 签名，获得最后的 Token 信息
		String token = builder.sign(ALGORITHM);

		return token;
	}

	/**
	 * <b>校验 Token 信息，获得该 Token 中的有效载荷数据</b>
	 * @param token
	 * @return
	 */
	public static Map<String,Object> verifyToken(String token){
		//校验此时所给定的 Token 是否符合相关形式
		if(token != null && !"".equals(token.trim())){
			//此时 Token 格式有效
			//获得 Token 校验对象 JWTVerifier
			JWTVerifier verifier = JWT.require(ALGORITHM).build();
			// 对于该 Token 进行校验
			DecodedJWT decodedJWT = verifier.verify(token);
			// 如果能够获得 DecodedJWT 则说明通过秘钥能够将加密 Token 进行解密
			// 提取绑定在 Token 中的有效载荷信息
			Map<String, Object> params = decodedJWT.getClaim("message").asMap();
			return params;
		}
		return null;
	}

}
