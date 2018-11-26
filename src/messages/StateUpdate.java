package com.stefanolupo.websocketbackend.messages;

import com.stefanolupo.websocketbackend.GameObject;
import java.util.Map;

public class StateUpdate
  extends Message
{
  private Map<String, GameObject> gameObjectMap;
  
  public Message.MessageType getMessageType()
  {
    return Message.MessageType.STATE_UPDATE;
  }
  
  public StateUpdate() {}
  
  public void setGameObjectMap(Map<String, GameObject> gameObjectMap)
  {
    this.gameObjectMap = gameObjectMap;
  }
  
  public StateUpdate(Map<String, GameObject> gameObjectMap) {
    this.gameObjectMap = gameObjectMap;
  }
  
  public Map<String, GameObject> getGameObjectMap()
  {
    return gameObjectMap;
  }
}
