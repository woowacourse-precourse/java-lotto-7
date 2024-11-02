package lotto.validation;

import static lotto.validation.LottoNumberValidator.validateBonusNumber;

import java.util.List;
import lotto.domain.Lotto;
import lotto.view.input.InputErrorMessage;
import lotto.view.input.InvalidInputException;

public class BonusNumberValidator {

    public static void validate(String input) {
        validateBonusNumber(input);
        validateLottoRange(input);
    }

    private static void validateLottoRange(String input) {
        int inputNumber = Integer.parseInt(input);
        if (inputNumber < 1 || inputNumber > 45) {
            throw new InvalidInputException(InputErrorMessage.LOTTO_NUMBER_RANGE_INVALID);
        }
    }

    public static void validateDuplicate(Integer input, Lotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        if (winningNumbers.contains(input)) {
            throw new InvalidInputException(InputErrorMessage.LOTTO_NUMBER_CANNOT_DUPLICATE);
        }
    }
}
