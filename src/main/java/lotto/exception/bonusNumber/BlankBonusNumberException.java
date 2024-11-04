package lotto.exception.bonusNumber;

public class BlankBonusNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "보너스 번호를 입력해야 합니다.";

    public BlankBonusNumberException() {
        super(ERROR_MESSAGE);
    }
}
