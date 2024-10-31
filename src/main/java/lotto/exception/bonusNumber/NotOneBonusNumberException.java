package lotto.exception.bonusNumber;

public class NotOneBonusNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "보너스 번호는 한자리만 입력해야 합니다";

    public NotOneBonusNumberException() {
        super(ERROR_MESSAGE);
    }
}
