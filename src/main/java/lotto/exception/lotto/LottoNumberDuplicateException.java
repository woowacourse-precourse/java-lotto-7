package lotto.exception.lotto;

public class LottoNumberDuplicateException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다.";

    public LottoNumberDuplicateException() {
        super(ERROR_MESSAGE);
    }
}
