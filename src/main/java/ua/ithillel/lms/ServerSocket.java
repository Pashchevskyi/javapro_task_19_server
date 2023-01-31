package ua.ithillel.lms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import lombok.RequiredArgsConstructor;
import ua.ithillel.lms.api.Processable;

@RequiredArgsConstructor
public class ServerSocket {
  private final int port;

  public void getRequest(Processable processable) {
    StringBuilder sb = new StringBuilder();
    try (
        java.net.ServerSocket serverSocket = new java.net.ServerSocket(port);
        Socket clientSocket = serverSocket.accept();
        ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())
    ) {
      String line;
      while ((line = in.readLine()) != null) {
        sb.append(line);
        processable.onRequest(line);
      }
    } catch (IOException e) {
      sb.append("EXCEPTION: " + e.getMessage());
    }
  }

  public void prepareResponse(String requestBody) {
    try (
    java.net.ServerSocket serverSocket = new java.net.ServerSocket(port);
    Socket clientSocket = serverSocket.accept();
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
    ) {
      out.println(requestBody);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
