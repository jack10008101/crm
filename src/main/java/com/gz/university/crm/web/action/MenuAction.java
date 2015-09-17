package com.gz.university.crm.web.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@ParentPackage("basePackage")
@Namespace("/")
@Action(value = "menuAction")
@Results({ @Result(name = "top", location = "/WEB-INF/page/menu/top.jsp"),
		@Result(name="left",location="/WEB-INF/page/menu/left.jsp") })
public class MenuAction extends ActionSupport {

	public String top() {
		/*
		 * System.out.println("hello"); System.out.println("world");
		 */
		return "top";
	}

	public String left() {
		return "left";
	}
}
