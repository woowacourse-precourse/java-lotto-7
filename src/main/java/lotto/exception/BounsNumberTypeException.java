package lotto.exception;

public class BounsNumberTypeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 보너스 번호는 숫자가 입력되어야 합니다";

    public BounsNumberTypeException() {
        super(ERROR_MESSAGE);
    }
}
