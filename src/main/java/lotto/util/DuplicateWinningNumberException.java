package lotto.util;

import static lotto.constant.ErrorMessage.DUPLICATE_WINNING_NUMBER;

public class DuplicateWinningNumberException extends RuntimeException {
    public DuplicateWinningNumberException() {
        super(DUPLICATE_WINNING_NUMBER.getMessage());
    }
}
