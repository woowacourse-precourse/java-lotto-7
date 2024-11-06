package lotto.exception;

public class BonusNumberDuplicationException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호와 중복되어서는 안됩니다";

    public BonusNumberDuplicationException() {
        super(ERROR_MESSAGE);
    }
}
