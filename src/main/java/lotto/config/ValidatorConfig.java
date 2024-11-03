package lotto.config;

import lotto.utils.inputValidator.comparison.BonusNumberValidator;
import lotto.utils.inputValidator.comparison.ComparisonValidator;
import lotto.utils.inputValidator.LottoNumberValidator;
import lotto.utils.inputValidator.PositiveIntValidator;
import lotto.utils.inputValidator.PurchaseAmountValidator;
import lotto.utils.inputValidator.InputValidator;
import lotto.utils.inputValidator.WinningNumbersValidator;

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
