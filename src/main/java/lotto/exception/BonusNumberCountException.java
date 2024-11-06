package lotto.exception;

public class BonusNumberCountException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 보너스 번호는 1개만 입력하여야 합니다";

    public BonusNumberCountException() {
        super(ERROR_MESSAGE);
    }
}
