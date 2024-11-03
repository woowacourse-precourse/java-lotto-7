package lotto.view.validator.money;

import static lotto.error.ErrorMessage.INVALID_ZERO_AMOUNT;

import lotto.model.money.Money;
import lotto.view.PreProcessor;
import lotto.view.validator.InputValidator;

public class MoneyZeroValidator extends InputValidator {

    private MoneyZeroValidator() { }

    public static MoneyZeroValidator initiate() {
        return new MoneyZeroValidator();
    }

    @Override
    public void validate(String input) {
        Money money = PreProcessor.stringToMoney(input);

        if (money.isZero(money)) {
            throw new IllegalArgumentException(INVALID_ZERO_AMOUNT.getMessage());
        }
    }
}
