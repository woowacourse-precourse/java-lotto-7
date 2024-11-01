package lotto.exception;

public class WinningNumberQuantityException extends WinningNumberException{
    private static final String MESSAGE = "로또 번호는 6개여야 합니다.";

    public WinningNumberQuantityException() {
        super(MESSAGE);
    }
}
