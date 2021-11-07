package cn.xll.wisemed.generator.system.user.transport;

import cn.xll.wisemed.generator.system.user.pojo.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <b>系统功能模块 - 基础用户传输层接口</b>
 * @author wang
 * @version 1.0.0
 */
@FeignClient("wisemed-system-provider")
@RequestMapping("/system/user/trans")
public interface UserTransport {

	/**
	 * <b>根据手机号码查询用户信息</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/cellphone")
	UserVO getUserByCellphone(@RequestParam String cellphone) throws Exception;
}
