package com.gz.university.crm.container;

import org.apache.commons.lang3.StringUtils;

public class ServiceProvider {
	private static ServiceProviderCore sc;
	static {
		sc = new ServiceProviderCore();
		sc.load(new String[] { "spring.xml", "spring-hibernate.xml" });
	}

	@SuppressWarnings("unused")
	public static Object getService(String beanName) {
		if (StringUtils.isBlank(beanName)) {
			throw new RuntimeException("您访问的服务名称不能为空");
		}
		Object bean = null;
		// 如果Spring容器中有beanName
		if (sc.ctx.containsBean(beanName)) {
			bean = sc.ctx.getBean(beanName);
		}
		if (bean==null) {
			throw new RuntimeException("您要访问的服务名称["+beanName+"]不存在");
		}
		return bean;

	}
}
