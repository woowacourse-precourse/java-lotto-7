package lotto.view;

import lotto.exception.ErrorMessage;

public class InputValidator {

    public void isDivisibleByThousand(long price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_DIVIDE_THOUSAND.get());
        }
    }
}
