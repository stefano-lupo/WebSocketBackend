package com.stefanolupo.websocketbackend.messages;


public class IdInform
  extends Message
{
  private String id;
  
  public Message.MessageType getMessageType()
  {
    return Message.MessageType.ID_INFORM;
  }
  
  public IdInform() {}
  
  public IdInform(String id) {
    this.id = id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getId() {
    return id;
  }
}
