package lotto.io.validator;

import lotto.io.validator.money.NullValidator;
import lotto.io.validator.money.ParsingValidator;
import lotto.io.validator.money.RegexValidator;
import lotto.io.validator.money.ThousandUnitValidator;

public class InputValidatorFacade {

    private InputValidatorFacade() {
    }

    public static void purchaseAmountValidators(final String source) {
        NullValidator nullValidator = new NullValidator();
        RegexValidator regexValidator = new RegexValidator();
        ParsingValidator parsingValidator = new ParsingValidator();
        ThousandUnitValidator thousandUnitValidator = new ThousandUnitValidator();

        nullValidator
                .doChain(regexValidator)
                .doChain(parsingValidator)
                .doChain(thousandUnitValidator);

        nullValidator.check(source);
    }
}
