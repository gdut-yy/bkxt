package entity;

public class Major {
	  private String mcode;     //专业代码
	  private String mname;     //专业名称
	  private int plannum;      //计划录取人数
	  private int applynum;     //实际报考人数
	  private int passscore;    //录取分数线
	  private int admitnum;     //实际录取人数
	 
	  public String getMcode() {
	    return mcode;
	  }
	  public void setMcode(String mcode) {
	    this.mcode = mcode;
	  }
	  public String getMname() {
	    return mname;
	  }
	  public void setMname(String mname) {
	    this.mname = mname;
	  }
	  public int getPlannum() {
	    return plannum;
	  }
	  public void setPlannum(int plannum) {
	    this.plannum = plannum;
	  }
	  public int getApplynum() {
	    return applynum;
	  }
	  public void setApplynum(int applynum) {
	    this.applynum = applynum;
	  }
	  public int getPassscore() {
	    return passscore;
	  }
	  public void setPassscore(int passscore) {
	    this.passscore = passscore;
	  }
	  public int getAdmitnum() {
	    return admitnum;
	  }
	  public void setAdmitnum(int admitnum) {
	    this.admitnum = admitnum;
	  }
}
