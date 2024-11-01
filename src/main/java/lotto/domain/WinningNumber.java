package lotto.domain;

import static lotto.error.LottoError.*;

import java.util.List;
import java.util.Arrays;

public class WinningNumber {
    private final List<Integer> winNumbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> winNumbers, int bonusNumber) {
        validate(winNumbers, bonusNumber);
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winNumbers, int bonusNumber) {
        if (winNumbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_COUNT.getMessage());
        }
        for (Integer number : winNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(INVALID_WINNING_NUMBER_RANGE.getMessage());
            }
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER.getMessage());
        }
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    public static List<Integer> parseWinningNumbers(String winningInput) {
        if (!winningInput.matches("\\d+(,\\s*\\d+){5}")) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_DELIMITER.getMessage());
        }

        String[] numberStrings = winningInput.split(",");
        List<Integer> winNumbers = Arrays.stream(numberStrings)
                .map(String::trim)
                .map(numberString -> {
                    try {
                        return Integer.parseInt(numberString);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_FORMAT.getMessage());
                    }
                })
                .toList();

        return winNumbers;
    }

    public List<Integer> getWinNumbers() {
        return winNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
