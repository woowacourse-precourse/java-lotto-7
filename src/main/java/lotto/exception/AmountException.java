package lotto.exception;

public class AmountException {

    private static final String MESSAGE_AMOUNT_NUMBER = "[ERROR] 구입 금액은 숫자만 입력 가능합니다";
    private static final String MESSAGE_AMOUNT_THOUSAND = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";
    private static final String MESSAGE_AMOUNT_ZERO = "[ERROR] 구입 금액은 1,000원 이상부터 가능합니다.";

    public static void exceptionAmountNumber() {
        throw new IllegalArgumentException(MESSAGE_AMOUNT_NUMBER);
    }

    public static void exceptionAmountThousand() {
        throw new IllegalArgumentException(MESSAGE_AMOUNT_THOUSAND);
    }

    public static void exceptionAmountZero() {
        throw new IllegalArgumentException(MESSAGE_AMOUNT_ZERO);
    }

}
