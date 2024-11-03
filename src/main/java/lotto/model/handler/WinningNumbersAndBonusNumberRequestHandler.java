package lotto.model.handler;

import java.util.List;
import lotto.utils.InputUtils;
import lotto.validator.InputValidator;

public class WinningNumbersAndBonusNumberRequestHandler {

    public List<Integer> getWinningNumbers(List<String> lottoInput) {
        InputValidator.validateWinningNumbers(lottoInput);

        return InputUtils.convertToIntList(lottoInput);
    }

    public int getBonusNumber(String bonusInput, List<Integer> winningNumbers) {
        InputValidator.validateBonusNumber(bonusInput, winningNumbers);

        return InputUtils.convertToInt(bonusInput);
    }

}
