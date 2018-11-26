package com.stefanolupo.websocketbackend.messages;

public abstract class Message
{
  public Message.MessageType messageType;
  
  public Message() {}
  
  public abstract Message.MessageType getMessageType();
}
