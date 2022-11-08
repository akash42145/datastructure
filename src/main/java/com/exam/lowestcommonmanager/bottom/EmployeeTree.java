package com.exam.lowestcommonmanager.bottom;

public class EmployeeTree {
	
	private String name;
	
	private EmployeeTree reportingManager;

	public EmployeeTree(String name, EmployeeTree reportingManager) {
		super();
		this.name = name;
		this.reportingManager = reportingManager;
	}
	

	public EmployeeTree(String name) {
		super();
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmployeeTree getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(EmployeeTree reportingManager) {
		this.reportingManager = reportingManager;
	}
	
	
	public void addAsManager(EmployeeTree[] repotees) {
	      for (EmployeeTree repotee : repotees) {
	    	  repotee.setReportingManager(this); 
	      }
	}
	

}
