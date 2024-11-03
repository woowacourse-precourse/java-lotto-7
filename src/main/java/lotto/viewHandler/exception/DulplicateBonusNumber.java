package lotto.viewHandler.exception;

public class DulplicateBonusNumber extends MyException {
  public DulplicateBonusNumber() {
    super();
  }

  public DulplicateBonusNumber(String message) {
    super(message);
  }

  public DulplicateBonusNumber(String message, Throwable cause) {
    super(message, cause);
  }

  public DulplicateBonusNumber(Throwable cause) {
    super(cause);
  }
}
