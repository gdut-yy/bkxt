package entity;

public class Adminuser {
	private int adminid;      //����ԱID
	  private String adminname; //����Ա����
	  private String adminpass; //����Ա����
	  private String admingroup;     //����Ա������
	  public int getAdminid() {
	    return adminid;
	  }
	  public void setAdminid(int adminid) {
	    this.adminid = adminid;
	  }
	  public String getAdminname() {
	    return adminname;
	  }
	  public void setAdminname(String adminname) {
	    this.adminname = adminname;
	  }
	  public String getAdminpass() {
	    return adminpass;
	  }
	  public void setAdminpass(String adminpass) {
	    this.adminpass = adminpass;
	  }
	  public String getAdmingroup() {
	    return admingroup;
	  }
	  public void setAdmingroup(String admingroup) {
	    this.admingroup = admingroup;
	  }
}
