package lotto.validation;

import java.util.List;
import lotto.domain.Lotto;
import lotto.view.input.InputErrorMessage;
import lotto.view.input.InvalidInputException;

public class BonusNumberValidator {

    public static void validateBonusNumber(String input) {
        CommonLottoNumberValidator.validateNotNullOrEmpty(input);
        validateIsNumber(input);
        CommonLottoNumberValidator.validateLottoRange(Integer.parseInt(input));
    }

    private static void validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(InputErrorMessage.INTEGER_REQUIRED);
        }
    }

    public static void validateDuplicate(Integer input, Lotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        if (winningNumbers.contains(input)) {
            throw new InvalidInputException(InputErrorMessage.LOTTO_NUMBER_CANNOT_DUPLICATE);
        }
    }
}
