package com.stefanolupo.websocketbackend.decoders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stefanolupo.websocketbackend.messages.NodeUpdate;
import javax.websocket.DecodeException;
import javax.websocket.Decoder.Text;
import javax.websocket.EndpointConfig;


public class MessageDecoder
  implements Decoder.Text<NodeUpdate>
{
  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
  
  public MessageDecoder() {}
  
  public NodeUpdate decode(String s) throws DecodeException {
    try { return (NodeUpdate)OBJECT_MAPPER.readValue(s, NodeUpdate.class);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  
  public boolean willDecode(String s)
  {
    return s != null;
  }
  
  public void init(EndpointConfig endpointConfig) {}
  
  public void destroy() {}
}
