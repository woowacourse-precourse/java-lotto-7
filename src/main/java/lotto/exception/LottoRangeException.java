package lotto.exception;

public class LottoRangeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 1 ~ 45사이에 포함되어야 합니다";

    public LottoRangeException() {
        super(ERROR_MESSAGE);
    }
}
