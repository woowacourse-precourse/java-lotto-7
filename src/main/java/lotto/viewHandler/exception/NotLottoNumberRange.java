package lotto.viewHandler.exception;

public class NotLottoNumberRange extends RuntimeException {
  public NotLottoNumberRange() {
    super();
  }

  public NotLottoNumberRange(String message) {
    super(message);
  }

  public NotLottoNumberRange(String message, Throwable cause) {
    super(message, cause);
  }

  public NotLottoNumberRange(Throwable cause) {
    super(cause);
  }

  protected NotLottoNumberRange(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
