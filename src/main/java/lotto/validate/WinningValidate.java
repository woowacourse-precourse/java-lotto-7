package lotto.validate;

import java.util.HashSet;
import java.util.regex.Pattern;
import lotto.domain.Winning;
import lotto.message.WinningInputMessage;

public class WinningValidate {

    private static final String WINNITG_REGEX = "[0-9]+(,[0-9]+)*$";
    private static final String BONUS_REGEX = "[0-9]+";
    private static Pattern pattern;

    static Winning winning;

    public static boolean runValidBonusString(String bonusString) {
        try {
            if (!isNumeric(bonusString)) {
                throw new IllegalArgumentException(WinningInputMessage.INVALID_BONUS_NUMBER.getMessage());
            }

            int bonusNumber = Integer.parseInt(bonusString);

            if (!isLottoNumber(bonusNumber)) {
                throw new IllegalArgumentException(WinningInputMessage.INVALID_BONUS_NUMBER.getMessage());
            }

            if (!isBonusNotInWinning(winning, bonusNumber)) {
                throw new IllegalArgumentException(WinningInputMessage.DUPLICATE_WINNING_NUMBER.getMessage());
            }

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }

    public static boolean runValidWinningString(String winningInput) {
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

    public static boolean isBonusNotInWinning(Winning winning, int bonusNumber) {
        HashSet<Integer> winningSet = winning.getWinningNumbers();

        return winningSet.contains(bonusNumber);
    }

    public static boolean isLottoNumber(int bonusNumber) {
        return bonusNumber >= 1 && bonusNumber <= 45;
    }

    public static boolean isNumeric(String bonusString) {
        pattern = Pattern.compile(BONUS_REGEX);

        return pattern.matcher(bonusString).matches();
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
