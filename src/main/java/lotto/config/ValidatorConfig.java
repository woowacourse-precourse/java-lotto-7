package lotto.config;

import lotto.utils.validator.BonusNumberValidator;
import lotto.utils.validator.ComparisonValidator;
import lotto.utils.validator.LottoNumberValidator;
import lotto.utils.validator.PositiveIntValidator;
import lotto.utils.validator.PurchaseAmountValidator;
import lotto.utils.validator.InputValidator;
import lotto.utils.validator.WinningNumbersValidator;

public class ValidatorConfig {

    public InputValidator<String> positiveIntValidator(){
        return new PositiveIntValidator();
    }

    public InputValidator<Integer> lottoNumberValidator(){
        return new LottoNumberValidator();
    }

    public InputValidator<String> purchaseAmountValidator(){
        return new PurchaseAmountValidator(positiveIntValidator());
    }

    public InputValidator<String> WinningNumbersValidator(){
        return new WinningNumbersValidator(positiveIntValidator(), lottoNumberValidator());
    }

    public ComparisonValidator BonusNumberValidator(){
        return new BonusNumberValidator(positiveIntValidator(), lottoNumberValidator());
    }
}
