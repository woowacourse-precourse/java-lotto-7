package lotto.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidate {

    private final String REGEX = "[0-9]";
    private final Pattern pattern = Pattern.compile(REGEX);
    private Matcher matcher;

    private boolean isNumeric(String input) {
        matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
