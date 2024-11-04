package lotto.model;

import utils.ValidationManager;

public class Amount{
    private final int amount;
    private static final String REQUEST_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final String NOT_DIVISIBLE_BY_THOUSAND_ERROR = "[ERROR] 로또의 금액이 1000원 단위가 아닙니다.";
    private final String INPUT_ZERO_ERROR = "[ERROR] 로또의 금액은 0보다 커야합니다.";
    private final int amountDivisor = 1000;

    public Amount(String amountInput) {
        ValidationManager.isNumber(amountInput);
        ValidationManager.isNotEmptyInput(amountInput);
        isInputZero(amountInput);
        this.amount = isDivideByThousand(Integer.parseInt(amountInput));
    }

    private void isInputZero(String input) {
        if(input.matches("0*")){
            throw new IllegalArgumentException(INPUT_ZERO_ERROR);
        }
    }

    private int isDivideByThousand(int amountInput) {
        if (amountInput % amountDivisor == 0) {
            return amountInput;
        }
        throw new IllegalArgumentException(NOT_DIVISIBLE_BY_THOUSAND_ERROR);
    }

    public int getAmount() {
        return this.amount;
    }

    public static String getRequestMessage() {
        return REQUEST_AMOUNT_MESSAGE;
    }

    public int getPublishCount() {
        return this.amount / amountDivisor;
    }
}
