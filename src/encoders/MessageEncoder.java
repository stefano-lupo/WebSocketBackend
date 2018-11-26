package com.stefanolupo.websocketbackend.encoders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stefanolupo.websocketbackend.messages.Message;
import javax.websocket.EncodeException;
import javax.websocket.Encoder.Text;
import javax.websocket.EndpointConfig;

public class MessageEncoder
  implements Encoder.Text<Message>
{
  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
  
  public MessageEncoder() {}
  
  public String encode(Message message) throws EncodeException {
    try {
      s = OBJECT_MAPPER.writeValueAsString(message);
    } catch (Exception e) { String s;
      throw new RuntimeException(e);
    }
    String s;
    return s;
  }
  
  public void init(EndpointConfig endpointConfig) {}
  
  public void destroy() {}
}
