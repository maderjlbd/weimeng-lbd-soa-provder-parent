package com.weimob.arch.soa.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class SpringBeanUtils implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext appContext) throws BeansException {
		SpringBeanUtils.applicationContext = appContext;
	}

	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}

}
