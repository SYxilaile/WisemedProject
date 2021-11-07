package cn.xll.wisemed.generator.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <b>系统基础信息类 - 控制层基础类</b>
 * <p>
 *     该类依赖注入了如下信息：</br>
 *     1、HttpServletRequset</br>
 *     2、HttpServletResponse</br>
 *     3、HttpSession</br>
 *     其余所有控制层都必须<b>继承于本控制层基础类</b>。
 * </p>
 * @author wang
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller("baseController")
public class BaseController {
	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected  HttpServletResponse response;
	@Autowired
	protected HttpSession session;


}
