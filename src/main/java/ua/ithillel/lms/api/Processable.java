package ua.ithillel.lms.api;

@FunctionalInterface
public interface Processable {
  void onRequest(String response);
}
