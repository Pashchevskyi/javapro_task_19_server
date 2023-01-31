package ua.ithillel.lms.exception;

public class CommandTooManyArgumentsException extends Exception {
  public CommandTooManyArgumentsException(String commandText) {
    super("Command " + commandText + " has too many arguments");
  }
}
