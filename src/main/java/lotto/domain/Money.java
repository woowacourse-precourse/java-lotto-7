package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.view.InputView;

public class Money {
    public final int amount;
    public static final int DIVIDE_CONDITION = 1000;
    public final int trial;

    public Money(int amount) {
        this.amount = validate(amount);
        trial = this.amount / DIVIDE_CONDITION;
    }

    public int validate(int amount) {
        while (true) {
            try {
                validateDivide(amount);
                validateNegative(amount);
                return amount;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                amount = InputView.inputMoney();
            }
        }
    }

    public void validateDivide(int amount) {
        if (amount % DIVIDE_CONDITION != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DIVIDE);
        }
    }

    public void validateNegative(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_AMOUNT);
        }
    }
}