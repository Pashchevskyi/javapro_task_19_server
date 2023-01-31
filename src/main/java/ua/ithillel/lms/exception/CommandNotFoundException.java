package ua.ithillel.lms.exception;

public class CommandNotFoundException extends Exception {
  public CommandNotFoundException(String commandText) {
    super("Command " + commandText + " has not been found");
  }
}
