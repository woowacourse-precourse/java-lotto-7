package view.validator.winningNumber;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import view.PreProcessor;
import view.validator.InputValidator;

public class WinningNumRangeValidator extends InputValidator {

    private static final Pattern RANGE_NUMBER = Pattern.compile("^([1-9]|[1-3][0-9]|4[0-5])$");

    private WinningNumRangeValidator() {}

    public static WinningNumRangeValidator initiate() {
        return new WinningNumRangeValidator();
    }

    @Override
    public void validate(final String input) {
        List<String> numbers = PreProcessor.stringToStringList(input);

        boolean hasInvalidNumber = numbers.stream()
                .anyMatch(this::isNotValid);

        if (hasInvalidNumber) {
            throw new IllegalArgumentException("당첨 번호 중 1-45 범위 이외의 유효하지 않은 숫자가 존재합니다.");
        }
    }

    private boolean isNotValid(final String input) {
        Matcher matcher = RANGE_NUMBER.matcher(input);
        return !matcher.matches();
    }
}
