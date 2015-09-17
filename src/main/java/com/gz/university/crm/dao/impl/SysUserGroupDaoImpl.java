package com.gz.university.crm.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.gz.university.crm.dao.ISysUserGroupDao;
import com.gz.university.crm.entity.SysUserGroup;
@Repository(value=ISysUserGroupDao.DAO_NAME)
public class SysUserGroupDaoImpl extends CommonDaoImpl<SysUserGroup> implements ISysUserGroupDao{

	@Override
	public SysUserGroup findSys(String hql) {
		// TODO Auto-generated method stub
		Query query=this.getCurrentSession().createQuery(hql);
		SysUserGroup resultGroup=(SysUserGroup) query.uniqueResult();
		return resultGroup;
	}

	@Override
	public void deleteSysUserGroupsByIds(Integer [] ids) {
		// TODO Auto-generated method stub
		String hql="delete SysUserGroup u where u.sysUserGroupId in :ids";
		Query query=this.getCurrentSession().createQuery(hql);
		query.setParameterList("ids", ids);
		query.executeUpdate();
	}



	
}
