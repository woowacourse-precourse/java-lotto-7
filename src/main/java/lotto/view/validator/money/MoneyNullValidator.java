package lotto.view.validator.money;

import lotto.view.validator.NullValidator;

public class MoneyNullValidator extends NullValidator {

    private MoneyNullValidator() {
        super("구입금액은 빈 문자열일 수 없습니다.");
    }

    public static MoneyNullValidator initiate() {
        return new MoneyNullValidator();
    }
}
