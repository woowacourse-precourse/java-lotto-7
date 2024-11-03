package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.ErrorCode;

import java.util.regex.Pattern;

public class Input {
    private static final Pattern isWinningNumberPattern = Pattern.compile("^(0?[1-9]|[1-3][0-9]|4[0-5])(,(0?[1-9]|[1-3][0-9]|4[0-5])){5}$");

    public static String inputPrice() {
        while (true) {
            View.printInputPrice();
            String price = Console.readLine();
            try {
                validatePrice(price);
                return price;
            } catch (IllegalArgumentException e) {
                View.showError(e.getMessage());
            }
        }
    }

    public static String inputWinningNumber() {
        while (true) {
            View.printInputWinningNumber();
            String winningNumber = Console.readLine();
            try {
                validateWinningNumber(winningNumber);
                return winningNumber;
            } catch (IllegalArgumentException e) {
                View.showError(e.getMessage());
            }

        }
    }

    public static String inputBonusNumber() {
        while (true) {
            View.printInputBonusNumber();
            String bonusNumber = Console.readLine();
            try {
                validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                View.showError(e.getMessage());
            }
        }
    }

    private static void validatePrice(String input) throws IllegalArgumentException {
        validateInputNumeric(input);
        Integer price = Integer.parseInt(input);
        validatePriceDivisible(price);
    }

    private static void validateWinningNumber(String input) throws IllegalArgumentException {
        isWinningNumberFormat(input);
    }

    private static void validateBonusNumber(String input) throws IllegalArgumentException {
        validateInputNumeric(input);
        Integer bonusNumber = Integer.parseInt(input);
        validateBonusNumberInRange(bonusNumber);
    }

    private static void validateInputNumeric(String price) {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorCode.PRICE_POSITIVE_INTEGER.getErrorMessage());
        }
    }

    private static void validatePriceDivisible(Integer price) {
        if (price % 1000 != 0) {
            throw new NumberFormatException(ErrorCode.PRICE_DIVIDABLE_BY_UNIT.getErrorMessage());
        }
    }

    private static void isWinningNumberFormat(String input) {
        if (!isWinningNumberPattern.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorCode.WIN_NUMBER_PROPER.getErrorMessage());
        }
    }

    private static void validateBonusNumberInRange(Integer bonusNumber) {
        if (!(bonusNumber > 0 && bonusNumber < 46)) {
            throw new IllegalArgumentException(ErrorCode.BONUS_NUMBER_IN_RANGE.getErrorMessage());
        }
    }

}
