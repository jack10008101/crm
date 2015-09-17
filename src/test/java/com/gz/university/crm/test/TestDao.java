package com.gz.university.crm.test;




import org.junit.Test;

import com.gz.university.crm.container.ServiceProvider;
import com.gz.university.crm.dao.ISysUserGroupDao;

public class TestDao {
	@Test
	public void deleteByIds() {
		ISysUserGroupDao sysUserGroupDao = (ISysUserGroupDao) ServiceProvider
				.getService(ISysUserGroupDao.DAO_NAME);
		Integer[] ids = { 1, 2, 3 };
		sysUserGroupDao.deleteSysUserGroupsByIds(ids);
	}
}
