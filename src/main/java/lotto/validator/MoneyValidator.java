package lotto.validator;

import java.util.regex.Pattern;
import lotto.view.ErrorMessages;

public class MoneyValidator {
    private final String money;

    public MoneyValidator(String money) {
        this.money = money;
    }

    public String getMoney() {
        return money;
    }

    public void validate() {
        validateNumber();
    }

    private void validateNumber() {
        if (!Pattern.matches("-?\\d+", money)) {
            throw new IllegalArgumentException(ErrorMessages.NON_NUMERIC_CONTAINED.getMessage());
        }
    }
}
