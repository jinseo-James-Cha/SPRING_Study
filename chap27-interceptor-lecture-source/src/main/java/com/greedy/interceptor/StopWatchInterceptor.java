package com.greedy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * default 메소드 이전에는 모두 오버라이딩 해야 하는 책임을 가지기 때문에
 * HandlerInterceptorAdaptor를 이용해 부담을 줄여 사용했으나
 * default 메소드가 인터페이스에서 사용하게 된 1.8이후부터는 
 * 인터페이스만 구현하여 필요한 메소드만 오버라이딩해서 사용할 수 있다.
 * */
public class StopWatchInterceptor implements HandlerInterceptor{

	private final MenuService menuService;
	
	@Autowired
	public StopWatchInterceptor(MenuService menuService) {
		this.menuService = menuService;
	}
	
	/* 전처리 메소드 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("preHandler호출함!");
		
		long startTime = System.currentTimeMillis();
		
		request.setAttribute("startTime", startTime);
		
		/* return type - boolean
		 * 1. true - contoller를 이어서 호출
		 * 2. false - 핸들러 메소드 호출하지않음
		 *  */
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		System.out.println("postHandler호출함!");
		
		long startTime = (Long)request.getAttribute("startTime");
		request.removeAttribute("startTime"); // request attribute 를 지웠다.
		
		long endTime = System.currentTimeMillis();
		
		modelAndView.addObject("interval", endTime-startTime);
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		System.out.println("afterCompletion 호출");
		
		menuService.method();
		
	}

	
	
}
