package ua.ithillel.lms.model;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCConnection {
  private final String dbms;

  private final String host;

  private final int port;

  private final String login;

  private final String password;

  private final String database;

  protected Statement statement;

  public JDBCConnection() throws IOException, SQLException {
    try (Reader reader = new FileReader("./config/config.properties")) {
      Properties prop = new Properties();
      prop.load(reader);

      dbms = prop.getProperty("jdbc_connection.dbms", "postgres");
      host = prop.getProperty("jdbc_connection.host", "127.0.0.1");
      port = Integer.parseInt(prop.getProperty("jdbc_connection.port", "5432"));
      login = prop.getProperty("jdbc_connection.login", "postgres");
      password = prop.getProperty("jdbc_connection.password", "");
      database = prop.getProperty("jdbc_connection.database", "postgres");
      try (Connection connection = DriverManager.getConnection(
          "jdbc:" + dbms + "://" + host + ":" + port + "/" + database,
          login,
          password
      )) {
        statement = connection.createStatement();
      }
    }
  }
}
