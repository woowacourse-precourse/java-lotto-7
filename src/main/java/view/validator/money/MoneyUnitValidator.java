package view.validator.money;

import model.Money;
import view.InputView;
import view.validator.InputValidator;

public class MoneyUnitValidator extends InputValidator {

    private MoneyUnitValidator() { }

    public static MoneyUnitValidator initiate() {
        return new MoneyUnitValidator();
    }

    @Override
    public void validate(final String input) {
        Money money = InputView.getInstance().stringToMoney(input);

        if (money.isDivisible(money)) {
            throw new IllegalArgumentException("구입금액은 로또 금액으로 나누어 떨어져야 합니다.");
        }
    }
}
