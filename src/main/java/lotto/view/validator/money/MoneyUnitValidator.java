package lotto.view.validator.money;

import static lotto.error.ErrorMessage.INVALID_AMOUNT;

import lotto.model.money.Money;
import lotto.utils.PreProcessor;
import lotto.view.validator.InputValidator;

public class MoneyUnitValidator extends InputValidator {

    private MoneyUnitValidator() {
    }

    public static MoneyUnitValidator initiate() {
        return new MoneyUnitValidator();
    }

    @Override
    public void validate(final String input) {
        Money money = PreProcessor.stringToMoney(input);

        if (money.isDivisible(money)) {
            throw new IllegalArgumentException(INVALID_AMOUNT.getMessage());
        }
    }
}
