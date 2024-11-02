package lotto.exception;

public class LottoNumberSIzeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";

    public LottoNumberSIzeException() {
        super(ERROR_MESSAGE);
    }
}
