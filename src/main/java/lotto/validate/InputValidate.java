package lotto.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lotto.message.InputMessage;

public class InputValidate {

    private static final String REGEX = "[0-9]+";
    private static final Pattern pattern = Pattern.compile(REGEX);

    public static boolean run(String input) {
        String errorMessage = null;

        try {
            if (!isNumeric(input)) {
                throw new IllegalArgumentException(InputMessage.INVALID_INPUT_AMOUNT.getMessage());
            }

            int money = Integer.parseInt(input);

            if (!isLessThanFirstPrizeAmount(money)) {
                throw new IllegalArgumentException(InputMessage.OUT_OF_RANGE_AMOUNT.getMessage());
            }

        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
            System.err.println(errorMessage);
            return false;
        }

        return true;
    }

    public static boolean isNumeric(String input) {
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean isLessThanFirstPrizeAmount(int money) {
        return money >= 0 && money <= 2000000000;
    }
}
