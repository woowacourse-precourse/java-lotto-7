package lotto.validation;

import static lotto.validation.CommonLottoNumberValidator.validateLottoInput;

import java.util.List;
import lotto.domain.Lotto;
import lotto.view.input.InputErrorMessage;
import lotto.view.input.InvalidInputException;

public class BonusNumberValidator {

    public static void validate(String input) {
        validateLottoInput(input);
    }

    public static void validateDuplicate(Integer input, Lotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        if (winningNumbers.contains(input)) {
            throw new InvalidInputException(InputErrorMessage.LOTTO_NUMBER_CANNOT_DUPLICATE);
        }
    }
}
