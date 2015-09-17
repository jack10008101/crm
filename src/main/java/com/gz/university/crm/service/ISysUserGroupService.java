package com.gz.university.crm.service;



import java.util.List;

import com.gz.university.crm.bean.SysUSerGroupSearch;
import com.gz.university.crm.entity.SysUserGroup;
import com.gz.university.crm.form.SysUserGroupForm;

public interface ISysUserGroupService {
	public static final String SERVICE_NAME = "com.gz.university.crm.dao.impl.SysUserGroupDaoImpl";

	void saveSysUser(SysUserGroupForm sysUserGroupForm);

	SysUserGroup findSysUserGroupById(Integer id);
    /**
     * 按照封装的查询条件来查询
     * @param sysUSerGroupSearch
     * @return
     */
	List<SysUserGroup> findSysUserGroupBys(SysUSerGroupSearch sysUSerGroupSearch);
    /**
     * 更新数据
     * @param sysUserGroup
     */
	void updateSysUSerGroup(SysUserGroup sysUserGroup);
	/**
	 * 批量删除数据
	 * @param idsIntegers 数组
	 */

	void deleteSysUserGroupsByIds(Integer[] idsIntegers);

}
