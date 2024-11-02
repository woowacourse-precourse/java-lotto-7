package view.validator.money;

import model.Money;
import view.InputView;
import view.PreProcessor;
import view.validator.InputValidator;

public class MoneyZeroValidator extends InputValidator {

    private MoneyZeroValidator() { }

    public static MoneyZeroValidator initiate() {
        return new MoneyZeroValidator();
    }

    @Override
    public void validate(String input) {
        Money money = PreProcessor.stringToMoney(input);

        if (money.isZero(money)) {
            throw new IllegalArgumentException("구입금액은 0일 수 없습니다.");
        }
    }
}
