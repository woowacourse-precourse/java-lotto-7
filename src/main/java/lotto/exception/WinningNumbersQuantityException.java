package lotto.exception;

public class WinningNumbersQuantityException extends IllegalLottoNumberException {
    private static final String MESSAGE = "로또 번호는 6개여야 합니다.";

    public WinningNumbersQuantityException() {
        super(MESSAGE);
    }
}
