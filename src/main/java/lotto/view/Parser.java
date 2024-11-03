package lotto.view;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private static final String ERROR_NON_NUMERIC_PURCHASE_AMOUNT_MESSAGE =
            "[ERROR] 구입 금액은 정수 범위의 숫자로 이루어져 있어야 합니다.";
    private static final String ERROR_NON_NUMERIC_WINNING_NUMBER_MESSAGE = "[ERROR] 당첨 번호는 숫자로 이루어져 있어야 합니다.";
    private static final String ERROR_NON_NUMERIC_BONUS_NUMBER_MESSAGE = "[ERROR] 보너스 번호는 숫자로 이루어져 있어야 합니다.";

    private static final String DELIMITER_COMMA = ",";

    public static int parsePurchaseAmount(String input) {
        int purchaseAmount = 0;
        try {
            purchaseAmount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_NON_NUMERIC_PURCHASE_AMOUNT_MESSAGE);
        }

        return purchaseAmount;
    }

    public static List<Integer> parseWinningNumber(String input) {
        List<Integer> winningNumber;
        try {
            winningNumber = Arrays.stream(input.split(DELIMITER_COMMA))
                    .mapToInt(Integer::parseInt).boxed().toList();
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_NON_NUMERIC_WINNING_NUMBER_MESSAGE);
        }

        return winningNumber.stream().toList();
    }

    public static Integer parseBonusNumber(String input) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_NON_NUMERIC_BONUS_NUMBER_MESSAGE);
        }

        return bonusNumber;
    }
}
