package ua.ithillel.lms;

import lombok.RequiredArgsConstructor;
import ua.ithillel.lms.api.Processable;
import ua.ithillel.lms.exception.CommandNotFoundException;
import ua.ithillel.lms.exception.CommandTooFewArgumentsException;
import ua.ithillel.lms.exception.CommandTooManyArgumentsException;

@RequiredArgsConstructor
public class RequestProcessor implements Processable {

  private final CommandParser commandParser;

  @Override
  public void onRequest(String body) {
    try {
      commandParser.process();
    } catch (CommandTooFewArgumentsException | CommandTooManyArgumentsException |
             CommandNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
