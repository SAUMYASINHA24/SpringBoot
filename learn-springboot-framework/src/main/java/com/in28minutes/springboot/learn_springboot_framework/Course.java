package com.in28minutes.springboot.learn_springboot_framework;

public class Course {
	
	 int srno;
	 String courseName;
	 String platformName;
	 
	

	 public Course(int srno, String courseName, String platformName) {
			super();
			this.srno = srno;
			this.courseName = courseName;
			this.platformName = platformName;
		 }
	 
	 public int getSrno() {
		return srno;
	}
	 public void setSrno(int srno) {
		 this.srno = srno;
	 }
	 public String getCourseName() {
		 return courseName;
	 }
	 public void setCourseName(String courseName) {
		 this.courseName = courseName;
	 }
	 public String getPlatformName() {
		 return platformName;
	 }
	 public void setPlatformName(String platformName) {
		 this.platformName = platformName;
	 }
	
	 @Override
		public String toString() {
			return "Course [srno=" + srno + ", courseName=" + courseName + ", platformName=" + platformName + "]";
		}
	

}
