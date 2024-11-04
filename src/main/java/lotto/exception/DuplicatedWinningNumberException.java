package lotto.exception;

public class DuplicatedWinningNumberException extends IllegalArgumentException {
    private final static String ERROR_MESSAGE = "[ERROR] 보너스 번호가 당첨 번호와 중복되면 안됩니다.";

    public DuplicatedWinningNumberException() {
        super(ERROR_MESSAGE);
    }
}
