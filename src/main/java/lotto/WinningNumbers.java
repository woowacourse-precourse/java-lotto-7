package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WinningNumbers {
    private final static String ERROR_WINNING_NUMBERS_COUNT = "[ERROR] 당첨 번호는 6개여야 합니다.";
    private final static String ERROR_WINNING_NUMBERS_DUPLICATE = "[ERROR] 당첨 번호는 서로 중복되지 않아야합니다.";
    private final static String ERROR_WINNING_NUMBERS_RANGE = "[ERROR] 당첨 번호는 1에서 45사이의 숫자만 가능합니다.";
    private final static String ERROR_INVALID_NUMBER = "[ERROR] 유효하지 않는 번호입니다. ";
    private final static String DELIMITER = ",";
    private final static int LOTTO_NUMBER_COUNT = 6;
    private final static int LOTTO_MIN_NUMBER = 1;
    private final static int LOTTO_MAX_NUMBER = 45;
    private final List<Integer> winningNumbers;

    public WinningNumbers(String winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = splitWinningNumbers(winningNumbers);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    private void validate(String winningNumbers) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBERS_COUNT);
        }
        List<Integer> parsedNumbers = splitWinningNumbers(winningNumbers);
        if (parsedNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBERS_COUNT);
        } else if (new HashSet<>(parsedNumbers).size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBERS_DUPLICATE);
        } else if (!isNumbersInRange(parsedNumbers)) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBERS_RANGE);
        }
    }

    private List<Integer> splitWinningNumbers(String winningNumbers) {
        List<Integer> parsedNumbers = new ArrayList<>();
        for (String winningNumber : winningNumbers.split(DELIMITER)) {
            try {
                parsedNumbers.add(Integer.parseInt(winningNumber.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_INVALID_NUMBER + winningNumber);
            }
        }
        return parsedNumbers;
    }

    private boolean isNumbersInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (LOTTO_MIN_NUMBER > number || number > LOTTO_MAX_NUMBER) {
                return false;
            }
        }
        return true;
    }
}
