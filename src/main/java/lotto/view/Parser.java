package lotto.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Parser {

    private final static String ERROR_NOT_DIVISIBLE_BY_1000_MESSAGE = "[ERROR] 구입 금액은 1,000으로 나누어 떨어져야 합니다.";
    private final static String ERROR_NON_NUMERIC_WINNING_NUMBER_MESSAGE = "[ERROR] 당첨 번호는 숫자로 이루어져 있어야 합니다.";
    private final static String ERROR_COUNT_IS_NOT_6_WINNING_NUMBER_MESSAGE = "[ERROR] 당첨 번호는 총 6개 입력되어야 합니다.";
    private final static String ERROR_OUT_OF_RANGE_WINNING_NUMBER_MESSAGE =
            "[ERROR] 당첨 번호는 1에서 45 사이의 숫자로 이루어져 있어야 합니다.";
    private final static String ERROR_DUPLICATE_WINNING_NUMBER_MESSAGE =
            "[ERROR] 당첨 번호는 중복되지 않은 서로 다른 6개의 숫자가 입력 되어야 합니다.";

    private final static String DELIMITER_COMMA = ",";
    private final static int PURCHASE_AMOUNT_UNITS = 1000;
    private final static int ZERO = 0;
    private final static int WINNING_NUMBER_SIZE = 6;
    private final static int MINIMUM_WINNING_NUMBER = 1;
    private final static int MAXIMUM_WINNING_NUMBER = 45;

    public static int parsePurchaseAmount(String input) {
        int purchaseAmount = Integer.parseInt(input);
        validatePurchaseAmount(purchaseAmount);

        return purchaseAmount;
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % PURCHASE_AMOUNT_UNITS != ZERO) {
            throw new IllegalArgumentException(ERROR_NOT_DIVISIBLE_BY_1000_MESSAGE);
        }
    }

    public static List<Integer> parseWinningNumber(String input) {
        List<Integer> winningNumbers;
        try {
            winningNumbers = Arrays.stream(input.split(DELIMITER_COMMA))
                    .mapToInt(Integer::parseInt).boxed().toList();
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_NON_NUMERIC_WINNING_NUMBER_MESSAGE);
        }
        validateWinningNumber(winningNumbers);

        return winningNumbers.stream().toList();
    }

    private static void validateWinningNumber(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_COUNT_IS_NOT_6_WINNING_NUMBER_MESSAGE);
        }
        for (int winningNumber : winningNumbers) {
            if (winningNumber < MINIMUM_WINNING_NUMBER || winningNumber > MAXIMUM_WINNING_NUMBER) {
                throw new IllegalArgumentException(ERROR_OUT_OF_RANGE_WINNING_NUMBER_MESSAGE);
            }
        }
        if (new HashSet<>(winningNumbers).size() != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_WINNING_NUMBER_MESSAGE);
        }
    }
}
