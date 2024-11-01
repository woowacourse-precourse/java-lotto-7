package lotto.io.validator.money;

import static lotto.io.exception.SmallChangeException.invalidUnit;
import static lotto.model.money.Money.hasSmallChange;

import lotto.io.preprocessor.IOPreprocessor;
import lotto.model.money.Money;

public class ThousandUnitValidator extends InputValidator {

    @Override
    public void check(final String source) {
        Money money = IOPreprocessor.stringToMoney(source);

        if (hasSmallChange(money)) {
            throw invalidUnit();
        }

        super.check(source);
    }
}
