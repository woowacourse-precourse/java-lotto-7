package lotto.parse;

import static lotto.constant.Policy.WINNER_NUMBER_COMMA_REGEX;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.ExceptionMessage;

public class InputParser {

    public Long parsePurchaseAmount(String purchaseAmount) {
        try {
            return Long.parseLong(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_MUST_LONG, e);
        }
    }

    public List<Integer> parseWinnerNumber(String winnerNumber) {
        String[] split = winnerNumber.split(WINNER_NUMBER_COMMA_REGEX);
        List<Integer> winnerNumbers = new ArrayList<>();

        for (String number : split) {
            winnerNumbers.add(parseIntegerInWinnerNumber(number));
        }

        return winnerNumbers;
    }

    private Integer parseIntegerInWinnerNumber(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.WINNER_NUMBER_INVALID_COMMA_POSITION, e);
        }
    }

    public Integer parseBonusAmount(String bonusAmount) {
        try {
            return Integer.parseInt(bonusAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_MUST_INTEGER, e);
        }
    }
}
