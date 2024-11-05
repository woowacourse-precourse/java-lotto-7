package lotto.exception;

import static lotto.constants.ExceptionMessages.EMPTY_WINNING_NUMBER_INPUT;

public class EmptyWinningNumberInputException extends IllegalArgumentException {
    public EmptyWinningNumberInputException() {
        super(EMPTY_WINNING_NUMBER_INPUT);
    }
}
