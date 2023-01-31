package ua.ithillel.lms;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import lombok.RequiredArgsConstructor;
import ua.ithillel.lms.exception.CommandNotFoundException;
import ua.ithillel.lms.exception.CommandTooFewArgumentsException;
import ua.ithillel.lms.exception.CommandTooManyArgumentsException;
import ua.ithillel.lms.model.ActiveConnection;

@RequiredArgsConstructor
public class CommandParser {

  private final String commandText = "";

  private final String[] arguments = {};

  public void process() throws CommandTooFewArgumentsException, CommandTooManyArgumentsException,
      CommandNotFoundException {
    switch (commandText) {
      case "-exit": {
        try {
          ActiveConnection ac = new ActiveConnection();
          ac.delete();
        } catch (SQLException | IOException e) {
          System.out.println("CommandParser.process():26 EXCEPTION: " + e.getMessage());
        }
        System.exit(0);
      }
      break;
      case "-file": {
        if (arguments.length < 1) {
          throw new CommandTooFewArgumentsException(commandText);
        }
        if (arguments.length > 1) {
          throw new CommandTooManyArgumentsException(commandText);
        }
        File file = new File("./uploads/" + arguments[0]);
        if (!file.isFile()) {
          if (!file.isDirectory()) {
            file.mkdirs();
          }
          try {
            file.createNewFile();
          } catch (IOException e) {
            System.out.println("CommandParser.process():46 EXCEPTION: " + e.getMessage());
          }
        }
      }
      ;
      break;
      default: {
        throw new CommandNotFoundException(commandText);
      }
    }
  }
}
