package entity;

public class Grade {
  private int gardeid;          //鎴愮哗ID
  private String testcardnum;   //鍑嗚�冭瘉鍙�
  private String ccode;         //璇剧▼浠ｇ爜
  private int score;            //鎴愮哗
  private String note;          //澶囨敞锛氭甯搞�佺己鑰冦�佷綔寮�
  private String status;        //鐘舵�佹爣璇嗭細0锛氬彲褰曞叆  1锛氫笉鍙綍鍏�
  public int getGardeid() {
    return gardeid;
  }
  public void setGardeid(int gardeid) {
    this.gardeid = gardeid;
  }
  public String getTestcardnum() {
    return testcardnum;
  }
  public void setTestcardnum(String testcardnum) {
    this.testcardnum = testcardnum;
  }
  public String getCcode() {
    return ccode;
  }
  public void setCcode(String ccode) {
    this.ccode = ccode;
  }
  public int getScore() {
    return score;
  }
  public void setScore(int score) {
    this.score = score;
  }
  public String getNote() {
    return note;
  }
  public void setNote(String note) {
    this.note = note;
  }
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  
}
