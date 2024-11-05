package lotto.exception;

public class LottoNumberFormatException extends IllegalLottoNumberException {
    private static final String MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public LottoNumberFormatException() {
        super(MESSAGE);
    }
}
