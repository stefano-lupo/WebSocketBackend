package com.stefanolupo.websocketbackend;

import org.glassfish.tyrus.server.Server;

public class ServerRunner
{
  public ServerRunner() {}
  
  public static void main(String[] args)
  {
    ServerRunner serverRunner = new ServerRunner();
    serverRunner.runServer();
  }
  
  public void runServer() {
    Server server = new Server("localhost", 8025, "/websockets", null, new Class[] { GameEndpoint.class });
    try
    {
      server.start();
      java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
      System.out.println("Please press a key to stop the server.");
      reader.readLine();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      server.stop();
    }
  }
}
