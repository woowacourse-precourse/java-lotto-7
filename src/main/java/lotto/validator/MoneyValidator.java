package lotto.validator;

import java.util.regex.Pattern;
import lotto.view.Errors;
import lotto.view.Outputs;

public class MoneyValidator {
    private final String money;

    public MoneyValidator(String money) {
        this.money = money;
    }

    public String getMoney() {
        return money;
    }

    public void validate() {
        validateInteger();
    }

    protected void validateInteger() {
        if (!Pattern.matches("-?\\d+", money)) {
            throw new IllegalArgumentException(String.join(Outputs.SPACE.getMessage(),
                    Errors.ERROR.getMessage(),
                    Errors.NOT_AN_INTEGER.getMessage(),
                    Errors.NUMBER_REQUEST.getMessage())
            );
        }
    }
}
