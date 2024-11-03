package lotto.service;

import lotto.validator.InputValidator;
import lotto.validator.InputValidatorImpl;

public class LottoValidateServiceImpl implements LottoValidateService {
    InputValidator inputValidator;

    public LottoValidateServiceImpl() {
        inputValidator = new InputValidatorImpl();
    }

    public void validateLottoCost(String lottoPrice) {
        inputValidator.validateEmpty(lottoPrice);
        int lottoPriceInt = inputValidator.validateNumber(lottoPrice);
        inputValidator.validateNumberRange(lottoPriceInt);
        inputValidator.validateCostForm(lottoPriceInt);
    }

    public void validateWinningNumbers(String lottoWinningNumbers) {
        inputValidator.validateEmpty(lottoWinningNumbers);
        inputValidator.validateNumbersForm(lottoWinningNumbers);
    }

    public void validateBonusNumbers(String bonusNumber) {
        inputValidator.validateEmpty(bonusNumber);
        inputValidator.validateNumber(bonusNumber);
    }
}
