package lotto.model.handler;

import java.util.List;
import lotto.utils.InputUtils;
import lotto.validator.InputValidator;

public class WinningNumbersRequestHandler {

    public List<Integer> getNumbers(List<String> numbersInput) {
        InputValidator.validateNumbers(numbersInput);

        return InputUtils.convertToIntList(numbersInput);
    }

    public int getBonusNumber(String bonusInput, List<Integer> numbers) {
        InputValidator.validateBonusNumber(bonusInput, numbers);

        return InputUtils.convertToInt(bonusInput);
    }

}
