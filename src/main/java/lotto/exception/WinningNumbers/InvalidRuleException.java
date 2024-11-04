package lotto.exception.WinningNumbers;

public class InvalidRuleException extends IllegalArgumentException {
    private static final String errorMessage = "숫자와 쉼표(,) 구분자를 사용해야 합니다.";

    public InvalidRuleException() {
        super(errorMessage);
    }
}
