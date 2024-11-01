package lotto.Utils;

import lotto.Constants.Error;

public class NumberUtils {
    public static int parseStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.PARSE_INT_ERROR.getText());
        }
    }
}
