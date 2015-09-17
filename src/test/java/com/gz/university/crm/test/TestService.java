package com.gz.university.crm.test;

import java.io.Serializable;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gz.university.crm.container.ServiceProvider;
import com.gz.university.crm.dao.ISysUserGroupDao;
import com.gz.university.crm.entity.SysUserGroup;
import com.gz.university.crm.service.ISysUserGroupService;

public class TestService {
	@Test
	public void testSave() {

		String[] paths = { "classpath:spring.xml",
				"classpath:spring-hibernate.xml" };
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				paths);
		ISysUserGroupService sysUserGroupService = (ISysUserGroupService) applicationContext
				.getBean(ISysUserGroupService.SERVICE_NAME);

	}

	@Test
	public void testServiceProvider() {
		ISysUserGroupService userGroupService = (ISysUserGroupService) ServiceProvider
				.getService("xxxx");
	}

	@Test
	public void testSaveSysUserGroup() {
		SysUserGroup sysUserGroup = new SysUserGroup();
		sysUserGroup.setName("销售部01");
		sysUserGroup.setPrincipal("tom");
		sysUserGroup.setIncumbent("销售物品。。。。。。。");
		ISysUserGroupService userGroupService = (ISysUserGroupService) ServiceProvider
				.getService(ISysUserGroupService.SERVICE_NAME);
		//userGroupService.saveSysUser(sysUserGroup);
	}

	public void findSysUserGroupById() {
		ISysUserGroupService userGroupService = (ISysUserGroupService) ServiceProvider
				.getService(ISysUserGroupService.SERVICE_NAME);
		Serializable id = 1;
		//SysUserGroup sysUserGroup = userGroupService.findSysUserGroupById(id);
		//System.out.println(sysUserGroup.getName());
	}

	@Test
	public void deleteByIds() {
		ServiceProvider.getService(ISysUserGroupDao.DAO_NAME);
	}

	@Test
	public void findSysUserGroups() {
		// 获取部门名称
		String name = "销售部";
		// 获取部门负责人
		String principle = "tom";
		ISysUserGroupService userGroupService = (ISysUserGroupService) ServiceProvider
				.getService(ISysUserGroupService.SERVICE_NAME);
		/*List<SysUserGroup> lists = userGroupService
				.findSysUserGroupsByNameAndPrinciple(name, principle);*/
	}

}
