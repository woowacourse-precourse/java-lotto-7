package lotto.exception;

public class LottoInvalidException extends IllegalArgumentException {
    private static final String DEFAULT_MESSAGE = "로또 번호는 숫자어야합니다.";

    public LottoInvalidException() {
        super(DEFAULT_MESSAGE);
    }
}
