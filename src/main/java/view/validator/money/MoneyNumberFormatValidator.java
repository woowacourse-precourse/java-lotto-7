package view.validator.money;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import view.validator.InputValidator;

public class MoneyNumberFormatValidator extends InputValidator {

    private static final Pattern pattern = Pattern.compile("^[0-9]+$");

    private MoneyNumberFormatValidator() { }

    public static MoneyNumberFormatValidator initiate() {
        return new MoneyNumberFormatValidator();
    }

    @Override
    public void validate(final String input) {
        if (isNotValid(input)) {
            throw new IllegalArgumentException("구입금액은 양수여야 합니다.");
        }
    }

    private boolean isNotValid(final String input) {
        Matcher matcher = pattern.matcher(input);
        return !matcher.matches();
    }
}
