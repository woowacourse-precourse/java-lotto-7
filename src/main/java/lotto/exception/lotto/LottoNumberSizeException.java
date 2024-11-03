package lotto.exception.lotto;

public class LottoNumberSizeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";

    public LottoNumberSizeException() {
        super(ERROR_MESSAGE);
    }
}
