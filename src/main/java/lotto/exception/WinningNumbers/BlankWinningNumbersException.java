package lotto.exception.WinningNumbers;

public class BlankWinningNumbersException extends IllegalArgumentException {
    private static final String errorMessage = "당첨 번호를 입력해야 합니다.";

    public BlankWinningNumbersException() {
        super(errorMessage);
    }
}
