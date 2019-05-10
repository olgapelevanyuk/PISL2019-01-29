package by.it.group673602.blinets.lab5_6_7.exceptions;

public class UniqueObjectException extends ServiceException {

  public UniqueObjectException() {
    super("Object already exists");
  }
}
