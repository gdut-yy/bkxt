package entity;

public class Record {
	private int rid;          //��¼ID
	  private String logname;   //�û���
	  private String usergroup; //�û���
	  private String logtime;   //��¼ʱ��
	  private String logip;     //��¼ip
	  public int getRid() {
	    return rid;
	  }
	  public void setRid(int rid) {
	    this.rid = rid;
	  }
	  public String getLogname() {
	    return logname;
	  }
	  public void setLogname(String logname) {
	    this.logname = logname;
	  }
	  
	  public String getUsergroup() {
	    return usergroup;
	  }
	  public void setUsergroup(String usergroup) {
	    this.usergroup = usergroup;
	  }
	  public String getLogtime() {
	    return logtime;
	  }
	  public void setLogtime(String logtime) {
	    this.logtime = logtime;
	  }
	  public String getLogip() {
	    return logip;
	  }
	  public void setLogip(String logip) {
	    this.logip = logip;
	  }	
}
