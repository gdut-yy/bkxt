package entity;

public class SupGrade extends Grade{
	private String sname;
	private String coursename;
	public void setSname(String sname){
		this.sname = sname;
	}
	public String getSname(String sname){
		return this.sname;
	}
	public void setCname(String coursename){
		this.coursename = coursename;
	}
	public String getCname(){
		return this.coursename;
	}
}
