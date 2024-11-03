package lotto.view.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFormatValidator extends InputValidator {

    private static final Pattern pattern = Pattern.compile("^[0-9]+$");
    private final String errorMessage;

    protected NumberFormatValidator(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void validate(final String input) {
        if (isNotValid(input)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private boolean isNotValid(final String input) {
        Matcher matcher = pattern.matcher(input);
        return !matcher.matches();
    }
}