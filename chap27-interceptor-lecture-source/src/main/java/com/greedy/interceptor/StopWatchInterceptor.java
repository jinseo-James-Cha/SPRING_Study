package com.greedy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * default 메소드 이전에는 모두 오버라이딩 해야 하는 책임을 가지기 때문에
 * HandlerInterceptorAdaptor를 이용해 부담을 줄여 사용했으나
 * default 메소드가 인터페이스에서 사용하게 된 1.8이후부터는 
 * 인터페이스만 구현하여 필요한 메소드만 오버라이딩해서 사용할 수 있다.
 * */
public class StopWatchInterceptor implements HandlerInterceptor{

	/* intercept를 해서 처리한다. */
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	
	
}
