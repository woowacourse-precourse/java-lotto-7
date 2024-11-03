package lotto.validate;

import java.util.regex.Pattern;
import lotto.message.WinningInputMessage;

public class WinningValidate {

    private static final String WINNITG_REGEX = "[0-9]+(,[0-9]+)*$";
    private static Pattern pattern;

    public static boolean runValidString(String winningInput) {
        try {
            if (!isValidString(winningInput)) {
                throw new IllegalArgumentException(WinningInputMessage.INVALID_WINNING_INPUT_STRING.getMessage());
            }

            if (!isSixNumber(winningInput)) {
                throw new IllegalArgumentException(WinningInputMessage.INVALID_WINNING_INPUT_STRING.getMessage());
            }

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean isSixNumber(String winningInput) {
        String[] winningArray = winningInput.split(",");

        return winningArray.length == 6;
    }

    public static boolean isValidString(String winningInput) {
        pattern = Pattern.compile(WINNITG_REGEX);

        return pattern.matcher(winningInput).matches();
    }
}
