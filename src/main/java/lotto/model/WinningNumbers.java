package lotto.model;

import java.util.Arrays;
import java.util.List;
import lotto.Lotto;
import lotto.constants.ErrorMessages;

public class WinningNumbers {
    private static final String DELIMITER = ",";

    private final List<Integer> winningNumbers;

    private WinningNumbers(String userInputNumbers) {
        validate(userInputNumbers);
        List<Integer> numbers = parseNumbers(userInputNumbers);
        Lotto.validate(numbers);
        this.winningNumbers = numbers;
    }

    private void validate(String userInputNumbers) {
        if (userInputNumbers.startsWith(DELIMITER) || userInputNumbers.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(ErrorMessages.START_END_DELIMITER.formatMessage());
        }
        if (userInputNumbers.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessages.WHITESPACE_IN_DELIMITER.formatMessage());
        }
        if (!userInputNumbers.matches("^[0-9,]+$")) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CHARACTERS.formatMessage());
        }
    }

    public static WinningNumbers from(String userInputNumbers) {
        return new WinningNumbers(userInputNumbers);
    }

    private List<Integer> parseNumbers(String userInputNumbers) {
        return Arrays.stream(userInputNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
