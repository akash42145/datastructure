package com.exam.lowestcommonmanager.up;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTree {
	
	private String name;
	
	List<EmployeeTree> directReportees;	

	public EmployeeTree(String name) {		
		this.name = name;
		this.directReportees = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EmployeeTree> getDirectReportees() {
		return directReportees;
	}

	public void addDirectReportees(List<EmployeeTree> directReportees) {
		this.directReportees.addAll(directReportees);
	}

	@Override
	public String toString() {
		return "[name=" + name + "]";
	}
	
	

}
