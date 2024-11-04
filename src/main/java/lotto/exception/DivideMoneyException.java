package lotto.exception;

public class DivideMoneyException extends IllegalArgumentException {
    private final static String ERROR_MESSAGE = "[ERROR] 금액은 1000원으로 나누어 떨어져야 합니다.";

    public DivideMoneyException() {
        super(ERROR_MESSAGE);
    }
}
