package lotto.exception;

public class LottoInvalidSizeException extends IllegalArgumentException {
    private static final String DEFAULT_MESSAGE = "로또 번호는 6개여야 합니다.";

    public LottoInvalidSizeException() {
        super(DEFAULT_MESSAGE);
    }
}
