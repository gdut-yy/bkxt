package entity;

public class Stage {
	private int stagenum;          //�׶α��
	  private String stagename;      //�׶�����
	  private String starttime;      //��ʼʱ��
	  private String endtime;        //����ʱ��
	  private String note;           //�׶�˵��
	  public int getStagenum() {
	    return stagenum;
	  }
	  public void setStagenum(int stagenum) {
	    this.stagenum = stagenum;
	  }
	  public String getStagename() {
	    return stagename;
	  }
	  public void setStagename(String stagename) {
	    this.stagename = stagename;
	  }
	  public String getStarttime() {
	    return starttime;
	  }
	  public void setStarttime(String starttime) {
	    this.starttime = starttime;
	  }
	  public String getEndtime() {
	    return endtime;
	  }
	  public void setEndtime(String endtime) {
	    this.endtime = endtime;
	  }
	  public String getNote() {
	    return note;
	  }
	  public void setNote(String note) {
	    this.note = note;
	  }
}
