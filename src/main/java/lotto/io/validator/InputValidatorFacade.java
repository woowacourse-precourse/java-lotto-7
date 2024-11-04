package lotto.io.validator;

import static lotto.io.preprocessor.IOPreprocessor.cleanWhiteBlanks;

import lotto.io.validator.bonus.AlreadyPickedNumberValidator;
import lotto.io.validator.bonus.BonusNumberNullValidator;
import lotto.io.validator.bonus.BonusNumberRegexValidator;
import lotto.io.validator.lotto.LottoLengthValidator;
import lotto.io.validator.lotto.LottoNullValidator;
import lotto.io.validator.lotto.LottoRegexValidator;
import lotto.io.validator.money.MoneyNullValidator;
import lotto.io.validator.money.MoneyParsingValidator;
import lotto.io.validator.money.MoneyRegexValidator;
import lotto.io.validator.money.ThousandUnitValidator;
import lotto.model.lotto.Lotto;

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

        String cleanedSource = cleanWhiteBlanks(source);
        moneyNullValidator.check(cleanedSource);
    }

    public static void lottoNumbersValidators(final String source) {
        LottoNullValidator lottoNullValidator = LottoNullValidator.initiate();
        LottoRegexValidator lottoRegexValidator = LottoRegexValidator.initiate();
        LottoLengthValidator lottoLengthValidator = LottoLengthValidator.initiate();

        lottoNullValidator
                .doChain(lottoRegexValidator)
                .doChain(lottoLengthValidator);

        String cleanedSource = cleanWhiteBlanks(source);
        lottoNullValidator.check(cleanedSource);
    }

    public static void bonusNumberValidator(final String source, final Lotto lotto) {
        BonusNumberNullValidator bonusNumberNullValidator = BonusNumberNullValidator.initiate();
        AlreadyPickedNumberValidator alreadyPickedNumberValidator = AlreadyPickedNumberValidator.from(lotto);
        BonusNumberRegexValidator bonusNumberRegexValidator = BonusNumberRegexValidator.initiate();

        bonusNumberNullValidator
                .doChain(alreadyPickedNumberValidator)
                .doChain(bonusNumberRegexValidator);

        String cleanedSource = cleanWhiteBlanks(source);
        bonusNumberNullValidator.check(cleanedSource);
    }
}
