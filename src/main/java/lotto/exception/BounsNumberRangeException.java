package lotto.exception;

public class BounsNumberRangeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 보너스 번호는 1 ~ 45 이내로 입력하셔야 합니다";

    public BounsNumberRangeException() {
        super(ERROR_MESSAGE);
    }
}
