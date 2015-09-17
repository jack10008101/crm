package com.gz.university.crm.container;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 主要作用用于加载Spring的配置文件
 * @author admin
 *
 */
public class ServiceProviderCore {
	protected ApplicationContext ctx;

	public void load(String[] filePath) {
		ctx = new ClassPathXmlApplicationContext(filePath);
	}

}
