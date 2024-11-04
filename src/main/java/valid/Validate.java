package valid;

import exception.ErrorMessage;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {

    private static final int THOUSAND_UNIT = 1_000;
    private static final int SIX_SIZE = 6;
    private static final String NUMERIC_PATTERN = "^\\d+$";

    public static void isThousandUnit(int purchaseAmount) {
        if (purchaseAmount % THOUSAND_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_INVALID_UNIT_MSG.getMessage());
        }
    }

    public static void isNumber(String input) {
        if (!input.matches(NUMERIC_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_FORMAT_MSG.getMessage());
        }
    }

    public static void isDuplicated(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);

        if (uniqueNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBERS_MSG.getMessage());
        }
    }

    public static void isSixNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != SIX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_WINNING_NUMBERS_MSG.getMessage());
        }
    }

    public static void isNotInWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        for (int winningNumber : winningNumbers) {
            if (bonusNumber == winningNumber) {
                throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_IN_WINNING_NUMBERS_MSG.getMessage());
            }
        }
    }

    public static void isPositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_NUMBER_MSG.getMessage());
        }
    }

    public static void isOneBetweenFortyFive(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ONE_BETWEEN_FORTY_FIVE_MSG.getMessage());
        }
    }
}
