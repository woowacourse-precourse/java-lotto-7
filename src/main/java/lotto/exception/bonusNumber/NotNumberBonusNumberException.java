package lotto.exception.bonusNumber;

public class NotNumberBonusNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "보너스 번호는 숫자를 입력해야 합니다.";

    public NotNumberBonusNumberException() {
        super(ERROR_MESSAGE);
    }
}
