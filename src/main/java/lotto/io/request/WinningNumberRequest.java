package lotto.io.request;

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
            throw new GameException("당첨 번호는 공백이 될 수 없습니다.");
        }
        if (!WINNING_NUMBER_PATTERN.matcher(winningNumbers).matches()) {
            throw new GameException("당첨 번호는 쉼표(,)로 구분된 숫자여야 합니다.");
        }
    }
}
