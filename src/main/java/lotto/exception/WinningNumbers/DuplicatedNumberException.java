package lotto.exception.WinningNumbers;

public class DuplicatedNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "당첨 번호는 중복되지 않은 숫자를 입력해야 합니다.";

    public DuplicatedNumberException() {
        super(ERROR_MESSAGE);
    }
}
