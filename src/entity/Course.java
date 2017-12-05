package entity;

public class Course {
	  private String ccode;         //课程代码
	  private String cname;         //课程名称
	  private String cmname;        //隶属专业
	  private String cstarttime;    //考试开始时间
	  private String cendtime;      //考试结束时间
	  
	  public String getCcode() {
	    return ccode;
	  }
	  public void setCcode(String ccode) {
	    this.ccode = ccode;
	  }
	  public String getCname() {
	    return cname;
	  }
	  public void setCname(String cname) {
	    this.cname = cname;
	  }
	  public String getCstarttime() {
	    return cstarttime;
	  }
	  public void setCstarttime(String cstarttime) {
	    this.cstarttime = cstarttime;
	  }
	  public String getCendtime() {
	    return cendtime;
	  }
	  public void setCendtime(String cendtime) {
	    this.cendtime = cendtime;
	  }
	  public String getCmname() {
	    return cmname;
	  }
	  public void setCmname(String cmname) {
	    this.cmname = cmname;
	  }
}
