package util;

public class Message {
  private String name;
  private String content;
  
  public Message(){}
  
  public Message(String messName,String messContent){
    this.setMess(messName, messContent);
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content; 
  }

  public void setMess(String messName,String messContent){
    this.name = messName;
    this.content = messContent;
  }
  
}
