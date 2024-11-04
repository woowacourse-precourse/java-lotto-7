package lotto.exception;

public class InvalidLottoNumberRangeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호의 범위는 1 ~ 45이어야 합니다.";

    public InvalidLottoNumberRangeException() {
        super(ERROR_MESSAGE);
    }
}
