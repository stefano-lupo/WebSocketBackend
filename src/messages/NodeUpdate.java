package com.stefanolupo.websocketbackend.messages;

import com.stefanolupo.websocketbackend.GameObject;

public class NodeUpdate extends Message
{
  private GameObject gameObject;
  
  public Message.MessageType getMessageType()
  {
    return Message.MessageType.NODE_UPDATE;
  }
  
  public NodeUpdate() {}
  
  public NodeUpdate(GameObject gameObject)
  {
    this.gameObject = gameObject;
  }
  
  public void setGameObject(GameObject gameObject) {
    this.gameObject = gameObject;
  }
  
  public GameObject getGameObject() {
    return gameObject;
  }
}
