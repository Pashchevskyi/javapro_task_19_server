package ua.ithillel.lms.model;

import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ActiveConnection extends Model {
  private String clientName;
  private LocalDateTime connectedAt;
  private Socket clientSocket;

  public ActiveConnection() throws IOException, SQLException {
    super();
    clientName = "client-" + ((new Random()).nextLong());
    connectedAt = LocalDateTime.now();
  }

  public boolean delete() throws SQLException {
    return statement.execute("DELETE FROM active_connection WHERE client_name = " + clientName);
  }

  public boolean insert() throws SQLException {
    return statement.execute(
        "INSERT INTO active_connection(client_name, connected_at, client_socket) " +
            "VALUES("+clientName+", TIMESTAMP '" +
            connectedAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))+"', " +
            clientSocket.toString()+");"
    );
  }
}
