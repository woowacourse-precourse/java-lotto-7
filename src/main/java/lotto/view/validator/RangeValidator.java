package lotto.view.validator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.view.PreProcessor;

public class RangeValidator extends InputValidator {

    private static final Pattern RANGE_NUMBER = Pattern.compile("^([1-9]|[1-3][0-9]|4[0-5])$");
    private final String errorMessage;

    protected RangeValidator(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void validate(final String input) {
        List<String> numbers = PreProcessor.stringToStringList(input);

        boolean hasInvalidNumber = numbers.stream()
                .anyMatch(this::isNotValid);

        if (hasInvalidNumber) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private boolean isNotValid(final String input) {
        Matcher matcher = RANGE_NUMBER.matcher(input);
        return !matcher.matches();
    }
}
