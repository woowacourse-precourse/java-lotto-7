package lotto.exception.bonusNumber;

public class InvalidRangeBonusNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "보너스 번호는 1~45 사이의 번호를 입력해야 합니다.";

    public InvalidRangeBonusNumberException() {
        super(ERROR_MESSAGE);
    }
}
