package com.gz.university.crm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gz.university.crm.bean.SysUSerGroupSearch;
import com.gz.university.crm.dao.ISysUserGroupDao;
import com.gz.university.crm.entity.SysUserGroup;
import com.gz.university.crm.form.SysUserGroupForm;
import com.gz.university.crm.service.ISysUserGroupService;

@Transactional(readOnly = true)
@Service(ISysUserGroupService.SERVICE_NAME)
public class SysUserGroupServiceImpl implements ISysUserGroupService {
	private ISysUserGroupDao sysUserGroupDao;

	public ISysUserGroupDao getSysUserGroupDao() {
		return sysUserGroupDao;
	}

	@Resource(name = ISysUserGroupDao.DAO_NAME)
	public void setSysUserGroupDao(ISysUserGroupDao sysUserGroupDao) {
		this.sysUserGroupDao = sysUserGroupDao;
	}

	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void saveSysUser(SysUserGroupForm sysUserGroupForm) {
		// TODO Auto-generated method stub
		SysUserGroup sysUserGroup=new SysUserGroup();
		BeanUtils.copyProperties(sysUserGroupForm, sysUserGroup, new String[]{"sysUserGroupId"});
		this.sysUserGroupDao.save(sysUserGroup);
	}

	@Override
	public SysUserGroup findSysUserGroupById(Integer id) {
		// TODO Auto-generated method stub
		final String hql = "from SysUserGroup u where u.sysUserGroupId =" + id;
		return sysUserGroupDao.findSys(hql);
	}
    /**
     * 根据页面传过来的查询信息，获取查询结果
     */
	@Override
	public List<SysUserGroup> findSysUserGroupBys(
			SysUSerGroupSearch sysGroupSearch) {
		// TODO Auto-generated method stub
		String hql = "from SysUserGroup t where 1=1";
		Map<String, Object> params = new HashMap<String, Object>();
		hql = addWhere(sysGroupSearch, hql, params);
		//String totalHql = "select count(*) " + hql;
		//hql = addOrder(sysUserGroupForm, hql);
		//DataGrid dg = new DataGrid();
		@SuppressWarnings("unchecked")
		List<SysUserGroup> list = (List<SysUserGroup>) this.sysUserGroupDao.find(hql, params);
		/*List<SysUserGroupForm> rows = new ArrayList<SysUserGroupForm>();
		changeModel(list, rows);*/
		//dg.setTotal(this.userDao.count(totalHql, params));
		//dg.setRows(rows);
		//return dg;
		return list;
	}

	private void changeModel(List<SysUserGroup> list,
			List<SysUserGroupForm> rows) {
		// TODO Auto-generated method stub
		if (list != null && list.size() > 0) {
			for (SysUserGroup sysUserGroup : list) {
				SysUserGroupForm u = new SysUserGroupForm();
				BeanUtils.copyProperties(sysUserGroup, u);
				rows.add(u);
			}
		}
	}

	private String addOrder(SysUserGroupForm sysUserGroupForm, String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	private String addWhere(SysUSerGroupSearch sysUSerGroupSearch, String hql,
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		if (StringUtils.isNotBlank(sysUSerGroupSearch.getName())) {
			hql += " and t.name like :name";
			params.put("name", "%%" + sysUSerGroupSearch.getName() + "%%");
		}
		return hql;
	}
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public void updateSysUSerGroup(SysUserGroup sysUserGroup) {
		// TODO Auto-generated method stub
		this.sysUserGroupDao.update(sysUserGroup);
	}
     @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public void deleteSysUserGroupsByIds(Integer[] idsIntegers) {
		// TODO Auto-generated method stub
		this.sysUserGroupDao.deleteSysUserGroupsByIds(idsIntegers);
	}



	

}
