package lotto.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.message.InputMessage;

public class InputValidate {

    private static final String REGEX = "[0-9]";
    private static final Pattern pattern = Pattern.compile(REGEX);

    public static boolean run(String input) {
        try {
            if (!isNumeric(input)) {
                throw new IllegalArgumentException(InputMessage.INVALID_INPUT_AMOUNT.getMessage());
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }

    private static boolean isNumeric(String input) {
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
