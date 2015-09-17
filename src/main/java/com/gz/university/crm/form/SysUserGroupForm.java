package com.gz.university.crm.form;

import java.io.Serializable;

/**
 * VO对象，在JSP页面显示
 * 
 * @author admin
 * 
 */
@SuppressWarnings("serial")
public class SysUserGroupForm implements Serializable {

	private Integer sysUserGroupId;
	private String remark;// 备注
	private String name;// 部门名称
	private String principal;// 部门负责人
	private String incumbent;// 部门职能

	public Integer getSysUserGroupId() {
		return sysUserGroupId;
	}

	public void setSysUserGroupId(Integer sysUserGroupId) {
		this.sysUserGroupId = sysUserGroupId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getIncumbent() {
		return incumbent;
	}

	public void setIncumbent(String incumbent) {
		this.incumbent = incumbent;
	}

}
