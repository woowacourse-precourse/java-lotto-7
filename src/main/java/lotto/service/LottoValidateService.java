package lotto.service;

import lotto.validator.InputValidatorImpl;

public class LottoValidateService {
    InputValidatorImpl inputValidator;

    public LottoValidateService() {
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
        int bonusNumberInt = inputValidator.validateNumber(bonusNumber);
    }
}
