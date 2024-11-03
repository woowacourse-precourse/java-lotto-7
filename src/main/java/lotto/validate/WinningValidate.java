package lotto.validate;

import lotto.message.WinningInputMessage;

public class WinningValidate {

    public static boolean runValidString(String winningInput) {
        try {
            if (!isValidString(winningInput)) {
                throw new IllegalArgumentException(WinningInputMessage.INVALID_WINNING_INPUT_STRING.getMessage());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean isValidString(String winningInput) {
        String[] winningArray = winningInput.split(",");

        return winningArray.length == 6;
    }
}
