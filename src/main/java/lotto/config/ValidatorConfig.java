package lotto.config;

import lotto.utils.validator.BonusNumberValidator;
import lotto.utils.validator.LottoNumberValidator;
import lotto.utils.validator.PositiveIntValidator;
import lotto.utils.validator.PurchaseAmountValidator;
import lotto.utils.validator.Validator;
import lotto.utils.validator.WinningNumbersValidator;

public class ValidatorConfig {

    public Validator<String> positiveIntValidator(){
        return new PositiveIntValidator();
    }

    public Validator<Integer> lottoNumberValidator(){
        return new LottoNumberValidator();
    }

    public Validator<String> purchaseAmountValidator(){
        return new PurchaseAmountValidator(positiveIntValidator());
    }

    public Validator<String> WinningNumbersValidator(){
        return new WinningNumbersValidator(positiveIntValidator(), lottoNumberValidator());
    }

    public Validator<String> BonusNumberValidator(){
        return new BonusNumberValidator(positiveIntValidator(), lottoNumberValidator());
    }
}
