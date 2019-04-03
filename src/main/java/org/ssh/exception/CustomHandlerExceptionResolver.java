package org.ssh.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName CustomHandlerExceptionResolver
 * @Description spring MVC 的异常处理器
 * @author wangFeng
 * @see
 * @date 2018年8月1日
 */
@Repository("customHandlerExceptionResolver")
public class CustomHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception e) {
		// TODO Auto-generated method stub
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("e", e);
		// 这里可根据不同异常引起类做不同处理方式，本例做不同返回页面。
//		String viewName = ClassUtils.getShortName(e.getClass());
		System.out.println("异常类型:"+e.getMessage());
		return new ModelAndView("name", model);
	}
}