package lotto.validation;

import static lotto.util.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.util.LottoConstants.MIN_LOTTO_NUMBER;

import lotto.view.input.InputErrorMessage;
import lotto.view.input.InvalidInputException;

public class CommonLottoNumberValidator {
    public static void validateNotNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInputException(InputErrorMessage.CANNOT_BE_NULL_OR_EMPTY);
        }
    }


    public static void validateLottoRange(Integer input) {
        if (input < MIN_LOTTO_NUMBER.getValue() || input > MAX_LOTTO_NUMBER.getValue()) {
            throw new InvalidInputException(InputErrorMessage.LOTTO_NUMBER_RANGE_INVALID);
        }
    }

}
