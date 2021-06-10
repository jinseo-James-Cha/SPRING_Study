package com.greedy.section01.advice.annotation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true) // weaving 작업을 해준다.
public class ContextConfiguration {

}
