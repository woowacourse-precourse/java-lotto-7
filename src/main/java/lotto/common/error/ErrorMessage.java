package lotto.common.error;

public interface ErrorMessage {
    String ERROR_PREFIX = "[ERROR] ";
    String getInfo();
    String getMessage();
    String getInfoMessage();
}
