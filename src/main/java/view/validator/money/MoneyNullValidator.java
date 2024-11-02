package view.validator.money;

import view.validator.InputValidator;

public class MoneyNullValidator extends InputValidator {

    private MoneyNullValidator() {}

    public static MoneyNullValidator initiate() {
        return new MoneyNullValidator();
    }

    @Override
    public void validate(final String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException("구입금액은 빈 문자열일 수 없습니다.");
        }
    }
}
