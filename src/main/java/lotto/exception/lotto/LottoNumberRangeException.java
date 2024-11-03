package lotto.exception.lotto;

public class LottoNumberRangeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 1~45 사이의 값이어야 합니다.";

    public LottoNumberRangeException() {
        super(ERROR_MESSAGE);
    }
}
