package lotto.io.validator;

import lotto.io.validator.lotto.LottoLengthValidator;
import lotto.io.validator.lotto.LottoNullValidator;
import lotto.io.validator.lotto.LottoRegexValidator;
import lotto.io.validator.money.MoneyNullValidator;
import lotto.io.validator.money.MoneyParsingValidator;
import lotto.io.validator.money.MoneyRegexValidator;
import lotto.io.validator.money.ThousandUnitValidator;

public class InputValidatorFacade {

    private InputValidatorFacade() {
    }

    public static void purchaseAmountValidators(final String source) {
        MoneyNullValidator moneyNullValidator = MoneyNullValidator.initiate();
        MoneyRegexValidator moneyRegexValidator = MoneyRegexValidator.initiate();
        MoneyParsingValidator moneyParsingValidator = MoneyParsingValidator.initiate();
        ThousandUnitValidator thousandUnitValidator = ThousandUnitValidator.initiate();

        moneyNullValidator
                .doChain(moneyRegexValidator)
                .doChain(moneyParsingValidator)
                .doChain(thousandUnitValidator);

        moneyNullValidator.check(source);
    }

    public static void lottoNumbersValidators(final String source) {
        LottoNullValidator lottoNullValidator = LottoNullValidator.initiate();
        LottoRegexValidator lottoRegexValidator = LottoRegexValidator.initiate();
        LottoLengthValidator lottoLengthValidator = LottoLengthValidator.initiate();

        lottoNullValidator
                .doChain(lottoRegexValidator)
                .doChain(lottoLengthValidator);

        lottoNullValidator.check(source);
    }
}
