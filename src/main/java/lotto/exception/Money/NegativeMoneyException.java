package lotto.exception.Money;

public class NegativeMoneyException extends IllegalArgumentException {
    private final static String ERROR_MESSAGE = "[Error] 금액은 양의 정수여야합니다.";

    public NegativeMoneyException() {
        super(ERROR_MESSAGE);
    }
}
