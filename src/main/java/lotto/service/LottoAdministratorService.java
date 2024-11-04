package lotto.service;

import lotto.model.administrator.Lotto;
import lotto.model.administrator.LottoBonusNumber;

public class LottoAdministratorService {

    ValidationService validationService = new ValidationService();

    public Lotto setWinningNumbers(final String winningNumbersInput) {
        return new Lotto(validationService.parseToIntegerWinningNumbers(winningNumbersInput));
    }

    public LottoBonusNumber setBonusNumber(final String bonusNumberInput) {
        return new LottoBonusNumber(validationService.parseToIntegerBonusNumber(bonusNumberInput));
    }
}
