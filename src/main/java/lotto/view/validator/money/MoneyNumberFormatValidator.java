package lotto.view.validator.money;

import lotto.view.validator.NumberFormatValidator;

public class MoneyNumberFormatValidator extends NumberFormatValidator {

    private MoneyNumberFormatValidator() {
        super("구입금액은 양수여야 합니다.");
    }

    public static MoneyNumberFormatValidator initiate() {
        return new MoneyNumberFormatValidator();
    }
}
