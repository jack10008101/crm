package com.gz.university.crm.web.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.BeanUtils;

import com.gz.university.crm.bean.DataType;
import com.gz.university.crm.bean.SysUSerGroupSearch;
import com.gz.university.crm.entity.SysUserGroup;
import com.gz.university.crm.form.SysUserGroupForm;
import com.gz.university.crm.service.ISysUserGroupService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
@ParentPackage("basePackage")
@Namespace("/")
@Action(value = "sysUserGroupAction")
@Results({
		@Result(name = "list", location = "/WEB-INF/page/sys/group/list.jsp"),
		@Result(name = "add", location = "/WEB-INF/page/sys/group/add.jsp"),
		@Result(name = "edit", location = "/WEB-INF/page/sys/group/edit.jsp"),
		@Result(name="toListAction" ,type="redirect",location="sysUserGroupAction!list.action")})
public class SysUserGroupAction extends ActionSupport implements
		ModelDriven<SysUserGroupForm>, ServletRequestAware {
	private ISysUserGroupService sysUserGroupService;
	private SysUserGroupForm sysUserGroupForm = new SysUserGroupForm();
	private HttpServletRequest request;

	public ISysUserGroupService getSysUserGroupService() {
		return sysUserGroupService;
	}

	@Resource(name = ISysUserGroupService.SERVICE_NAME)
	public void setSysUserGroupService(ISysUserGroupService sysUserGroupService) {
		this.sysUserGroupService = sysUserGroupService;
	}

	/**
	 * 显示部门信息查询页面
	 * 
	 * @return
	 */
	public String list() {
		SysUSerGroupSearch sysUSerGroupSearch = new SysUSerGroupSearch();
		sysUSerGroupSearch.setName(sysUserGroupForm.getName());
		// 调用业务层的方法查询
		try {
			List<SysUserGroup> sysUserGroups = this.sysUserGroupService
					.findSysUserGroupBys(sysUSerGroupSearch);
			this.request.setAttribute("sysUserGroups", sysUserGroups);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return "list";
	}

	/**
	 * 现实部门修改页面
	 * 
	 * @return
	 */
	public String edit() {
		// 获取部门的Id
		Integer sId = sysUserGroupForm.getSysUserGroupId();
		if (sId != null) {
			// 调用业务层方法
			SysUserGroup sysUserGroup = this.sysUserGroupService
					.findSysUserGroupById(sId);
			BeanUtils.copyProperties(sysUserGroup, sysUserGroupForm);
			// struts标签解析的时候会自动在栈顶找值
		}
		return "edit";
	}

	/**
	 * 跟新部门信息
	 * 
	 * @return
	 */
	public String update() {
		// 实例化POJO对象
		SysUserGroup sysUserGroup = new SysUserGroup();
		// 将VO对象赋值给POJO对象
		BeanUtils.copyProperties(sysUserGroupForm, sysUserGroup);
		this.sysUserGroupService.updateSysUSerGroup(sysUserGroup);
		return "toListAction";
	}

	/**
	 * 删除部门信息
	 * 
	 * @return
	 */
	public String delete() {
          //获取ids
		String []ids=request.getParameterValues("ids");
		Integer [] idsIntegers=DataType.convertStringArrayToIntegerArray(ids);
		this.sysUserGroupService.deleteSysUserGroupsByIds(idsIntegers);
		return "toListAction";
	}

	/**
	 * 显示部门信息添加页面
	 * 
	 * @return
	 */
	public String add() {
		return "add";
	}

	public void save() {
		this.sysUserGroupService.saveSysUser(sysUserGroupForm);
	}

	@Override
	public SysUserGroupForm getModel() {
		// TODO Auto-generated method stub
		return sysUserGroupForm;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
}
