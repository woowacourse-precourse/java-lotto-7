package lotto.validation;

import static lotto.validation.LottoNumberValidator.validateBonusNumber;

import java.util.List;
import lotto.view.input.InputError;
import lotto.view.input.InvalidInputException;

public class BonusNumberValidator {
    public static void validate(String input) {
        validateBonusNumber(input);
    }

    private static void validateLottoRange(Integer input) {
        if (input >= 1 && input <= 45) {
            throw new InvalidInputException(InputError.LOTTO_NUMBER_RANGE_INVALID);
        }
    }

    private static void validateDuplicate(Integer input, List<Integer> winningNumbers) {
        if (winningNumbers.contains(input)) {
            throw new InvalidInputException(InputError.LOTTO_NUMBER_CANNOT_DUPLICATE);
        }
    }
}
