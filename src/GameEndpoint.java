package com.stefanolupo.websocketbackend;

import com.stefanolupo.websocketbackend.decoders.MessageDecoder;
import com.stefanolupo.websocketbackend.encoders.MessageEncoder;
import com.stefanolupo.websocketbackend.messages.IdInform;
import com.stefanolupo.websocketbackend.messages.Message;
import com.stefanolupo.websocketbackend.messages.NodeUpdate;
import com.stefanolupo.websocketbackend.messages.StateUpdate;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.websocket.EncodeException;
import javax.websocket.OnError;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;

@javax.websocket.server.ServerEndpoint(value="/game/state", decoders={MessageDecoder.class}, encoders={MessageEncoder.class})
public class GameEndpoint
{
  public GameEndpoint() {}
  
  private ConcurrentHashMap<String, GameObject> gameObjectsById = new ConcurrentHashMap();
  private static Set<Session> clients = new java.util.concurrent.CopyOnWriteArraySet();
  
  @javax.websocket.OnOpen
  public void onOpen(Session session) throws IOException, EncodeException {
    clients.add(session);
    

    IdInform idInform = new IdInform(session.getId());
    sendMessage(idInform, session);
  }
  
  @javax.websocket.OnMessage
  public void onMessage(Session session, NodeUpdate nodeUpdate) throws IOException {
    gameObjectsById.put(session.getId(), nodeUpdate.getGameObject());
    broadcast(session);
  }
  
  @javax.websocket.OnClose
  public void onClose(Session session) throws IOException {
    clients.remove(session);
    gameObjectsById.remove(session.getId());
    broadcast(session);
  }
  
  @OnError
  public void onError(Session session, Throwable throwable) {
    throw new RuntimeException(throwable);
  }
  
  private synchronized void broadcast(Session originatingSession) throws IOException {
    StateUpdate stateUpdate = new StateUpdate(gameObjectsById);
    for (Session session : clients) {
      if (!session.equals(originatingSession))
      {
        try
        {

          session.getBasicRemote().sendObject(stateUpdate);
        } catch (IOException|EncodeException e) {
          e.printStackTrace();
        } }
    }
  }
  
  private void sendMessage(Message message, Session session) throws IOException, EncodeException {
    session.getBasicRemote().sendObject(message);
  }
}
