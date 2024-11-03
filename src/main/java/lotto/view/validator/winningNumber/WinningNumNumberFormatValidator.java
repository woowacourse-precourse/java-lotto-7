package lotto.view.validator.winningNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.view.validator.InputValidator;

public class WinningNumNumberFormatValidator extends InputValidator {

    private static final Pattern pattern = Pattern.compile("^([0-9]+,)*[0-9]+$");

    private WinningNumNumberFormatValidator() {}

    public static WinningNumNumberFormatValidator initiate() {
        return new WinningNumNumberFormatValidator();
    }

    @Override
    public void validate(final String input) {
        if (isNotValid(input)) {
            throw new IllegalArgumentException("당첨 번호는 양수이어야 합니다.");
        }
    }

    private boolean isNotValid(final String input) {
        Matcher matcher = pattern.matcher(input);
        return !matcher.matches();
    }
}
