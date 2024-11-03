package lotto.view.domain;

import lotto.view.global.exception.CustomException;
import lotto.view.global.exception.ErrorMessage;

public class Amount {
    private Integer value;

    public Amount(Integer amount) {
        validateAmount(amount);
        this.value = amount;
    }

    private void validateAmount(Integer amount) {
        validateDivisibleByThousand(amount);
    }

    private void validateDivisibleByThousand(Integer amount) {
        if (amount % 1000 != 0) {
            throw CustomException.of(ErrorMessage.INVALID_AMOUNT_DIVISIBILITY_ERROR);
        }
    }
}
