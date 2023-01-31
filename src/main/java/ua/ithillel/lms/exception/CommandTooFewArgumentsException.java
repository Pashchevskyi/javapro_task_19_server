package ua.ithillel.lms.exception;

public class CommandTooFewArgumentsException extends Exception {
  public CommandTooFewArgumentsException(String commandText) {
    super("Command " + commandText + " has too few arguments");
  }
}
