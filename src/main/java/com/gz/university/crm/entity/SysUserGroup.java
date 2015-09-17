package com.gz.university.crm.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
/**
 * POJO对象和数据库中的对应
 * @author admin
 *
 */
@SuppressWarnings("serial")
@Entity
@Table
public class SysUserGroup implements Serializable {
	
	private Integer sysUserGroupId;
	private String remark;// 备注
	private String name;// 部门名称
	private String principal;// 部门负责人
	private String incumbent;// 部门职能
    @Id
    @GeneratedValue
	public Integer getSysUserGroupId() {
		return sysUserGroupId;
	}

	public void setSysUserGroupId(Integer sysUserGroupId) {
		this.sysUserGroupId = sysUserGroupId;
	}
    @Lob
    @Basic(fetch=FetchType.LAZY)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    @Column(length=100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    @Column(length=50)
	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}
    @Column(length=150)
	public String getIncumbent() {
		return incumbent;
	}

	public void setIncumbent(String incumbent) {
		this.incumbent = incumbent;
	}

}
