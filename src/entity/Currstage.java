package entity;

public class Currstage {
	private int configid;        //���ñ��
	  private String adminname;    //������
	  private String settime;      //����ʱ��
	  private String stagename;    //��ǰ�׶�����
	  public int getConfigid() {
	    return configid;
	  }
	  public void setConfigid(int configid) {
	    this.configid = configid;
	  }
	  public String getAdminname() {
	    return adminname;
	  }
	  public void setAdminname(String adminname) {
	    this.adminname = adminname;
	  }
	  public String getSettime() {
	    return settime;
	  }
	  public void setSettime(String settime) {
	    this.settime = settime;
	  }
	  public String getStagename() {
	    return stagename;
	  }
	  public void setStagename(String stagename) {
	    this.stagename = stagename;
	  }
}
