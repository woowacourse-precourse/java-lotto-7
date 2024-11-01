package lotto.parse;

import static lotto.constant.Policy.WINNER_NUMBER_COMMA_REGEX;

import lotto.constant.ExceptionMessage;

public class InputParser {

    public Long parsePurchaseAmount(String purchaseAmount) {
        try {
            return Long.parseLong(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_MUST_LONG, e);
        }
    }

    public String[] parseWinnerNumber(String winnerNumber) {
        return winnerNumber.split(WINNER_NUMBER_COMMA_REGEX);
    }
}
