package lotto.exception.money;

public class DivideMoneyException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다.";

    public DivideMoneyException() {
        super(ERROR_MESSAGE);
    }
}
