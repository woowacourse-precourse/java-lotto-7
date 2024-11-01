package lotto.io.exception;

import static lotto.io.error.ErrorMessage.EMPTY_INPUT_BONUS_NUMBER;
import static lotto.io.error.ErrorMessage.EMPTY_INPUT_LOTTO_NUMBER;
import static lotto.io.error.ErrorMessage.EMPTY_INPUT_PURCHASE_AMOUNT;

public class EmptyInputException extends IllegalArgumentException {

    public EmptyInputException(final String message) {
        super(message);
    }

    public static EmptyInputException emptyPurchaseAmount() {
        return new EmptyInputException(EMPTY_INPUT_PURCHASE_AMOUNT);
    }

    public static EmptyInputException emptyLottoNumbers() {
        return new EmptyInputException(EMPTY_INPUT_LOTTO_NUMBER);
    }

    public static EmptyInputException emptyBonusNumber() {
        return new EmptyInputException(EMPTY_INPUT_BONUS_NUMBER);
    }
}
