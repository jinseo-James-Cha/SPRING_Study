package com.greedy.section02.locale.javaconfig;

import java.util.Date;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section02.locale.javaconfig.config.ContextConfiguration;

public class Application {

	public static void main(String[] args) {
		
		/* 
		 * i18n 소프트웨어의 국제화(InternationalizatioN)의 I와 N사이의 알파벳 갯수 18개)
		 * 소프트웨어를 국제화 하기 위해서는 처리해야할 작업들이 많다.
		 * 
		 *  1. 언어, 지역별 번역
		 *  2. OS/플랫폼 인코딩
		 *  3. 문자열 치환 방법 : 서버쪽, 클라이언트쪽 치환 중 서버쪽에서 하는게 좋다.
		 *                    Why? 사용자 디바이스에 리소스 및 렌더링 성능 이슈 발생
		 *  4. 국제화 UI(문자열 크기 변화, 폰트, 아이콘)
		 *  5. 쓰기 방향의 차이
		 *  6. 숫자, 공백, 화폐, 날짜, 주소, 측정단위 등
		 *  7. 타임존, 섬머타임 등 시각
		 *  8. 문자열 정렬 방법
		 * 
		 *  */
		ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
		String error404Message = context.getMessage("error.404", null, Locale.US);
		String error500Message = context.getMessage("error.500", new Object[] {"차진서", new Date()}, Locale.US);
		
		System.out.println("The I18N message for error.404 : " + error404Message);
		System.out.println("The I18N message for error.500 : " + error500Message);
		
	}

}
