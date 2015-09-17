package com.gz.university.crm.dao;



import com.gz.university.crm.entity.SysUserGroup;

public interface ISysUserGroupDao extends ICommonDao<SysUserGroup>{
public static final String DAO_NAME="Open Declaration com.gz.university.crm.dao.impl.SysUserGroupDaoImpl";

SysUserGroup findSys(String hql);

void deleteSysUserGroupsByIds(Integer []ids);



}
