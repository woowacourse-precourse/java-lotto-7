package lotto.view;

import lotto.exception.ErrorMessage;

public class ErrorView {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printMoneyParsingError() {
        System.out.println(ERROR_PREFIX + ErrorMessage.MONEY_PARSING_ERROR_MESSAGE.getMessage());
    }

    public void printWinningNumbersParsingError() {
        System.out.println(ERROR_PREFIX + ErrorMessage.WINNING_NUMBERS_PARSING_ERROR_MESSAGE.getMessage());
    }

    public void printBonusNumberParsingError() {
        System.out.println(ERROR_PREFIX + ErrorMessage.BONUS_NUMBER_PARSING_ERROR_MESSAGE.getMessage());
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }
}