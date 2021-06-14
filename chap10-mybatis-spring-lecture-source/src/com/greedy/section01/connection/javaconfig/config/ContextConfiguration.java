package com.greedy.section01.connection.javaconfig.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.greedy.section01.connection.javaconfig")
@PropertySource("connection-info.properties") // db연결 두번째방법 
public class ContextConfiguration {

	@Value("${oracle.dev.driver}")
	private String driver;
	
	@Value("${oracle.dev.url}")
	private String url;
	
	@Value("${oracle.dev.username}")
	private String username;
	
	@Value("${oracle.dev.password}")
	private String password;
	
	@Bean(destroyMethod = "close")
	public BasicDataSource dataSource() {
		
		/* BasicDataSource를 사용하려면
		 * -> commons-dbcp 라이브러리 추가
		 * -> 의존성 관계인 commons pool 라이브러리 추가 
		 * */
		BasicDataSource dataSource = new BasicDataSource();
		
		/* 첫번째 방법 - 직접 입력  */
//		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//        dataSource.setUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:xe");
//        dataSource.setUsername("GREEDY");
//        dataSource.setPassword("GREEDY");
//        dataSource.setDefaultAutoCommit(false); // 수동 커밋
		
		/* 두번째 방법 - properties 파일을 불러와 placeholder를 이용해 환경설정 */
		dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDefaultAutoCommit(false); // 수동 커밋
        
        return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(ApplicationContext context) throws Exception{
		/* mybatis와 spring 연결! 
		 * 따라서, mybatis-spring 라이브러리 추가!
		 * */
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		
		// mybatis 설정값추가
		// java file은 . 으로 연결해주고
		// 그 외 파일, 폴더는 / 로 연결해준다.
		factoryBean.setConfigLocation(context.getResource("com/greedy/section01/connection/javaconfig/config/mybatis-config.xml"));
		return factoryBean.getObject();
	}
	
	// 아래 Bean을 위해 위에 2개의 Bean이 필요하다.
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(ApplicationContext context) throws Exception{
		// 추가 라이브러리가 존재
		// spring-jdbc 라이브러리 추가 
		return new SqlSessionTemplate(sqlSessionFactory(context));
	}
}
