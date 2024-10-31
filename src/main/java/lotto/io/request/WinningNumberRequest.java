package lotto.io.request;

import lotto.exception.ErrorMessage;
import lotto.exception.GameException;

import java.util.regex.Pattern;

public record WinningNumberRequest(
    String value
) {

    private static final Pattern WINNING_NUMBER_PATTERN = Pattern.compile("^[0-9]+(,[0-9]+)*$");

    public WinningNumberRequest {
        validate(value);
    }

    private void validate(String winningNumbers) {
        if (winningNumbers == null || winningNumbers.isBlank()) {
            throw new GameException(ErrorMessage.INVALID_NOT_BLANK);
        }
        if (!WINNING_NUMBER_PATTERN.matcher(winningNumbers).matches()) {
            throw new GameException(ErrorMessage.INVALID_WINNING_NUMBER_PATTERN);
        }
    }
}
