package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private static final String EMPTY_INPUT_ERROR = "[ERROR] 당첨 번호가 입력되지 않았습니다.";
    private static final String INVALID_COUNT_ERROR = "[ERROR] 당첨 번호는 6개여야 합니다.";
    private static final String DUPLICATE_BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    private static final String DUPLICATE_WINNING_NUMBERS_ERROR = "[ERROR] 당첨 번호에 중복이 있을 수 없습니다.";
    private static final String INVALID_BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호는 1과 45 사이의 숫자여야 합니다.";
    private static final String INVALID_WINNING_NUMBER_ERROR = "[ERROR] 당첨 번호는 1과 45 사이의 숫자여야 합니다.";

    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String Seperator = ",";

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(String winningNumbersInput, String bonusNumberInput) {
        this.winningNumbers = parseWinningNumbers(winningNumbersInput);
        this.bonusNumber = parseBonusNumber(bonusNumberInput);
        validateWinningNumbers(this.winningNumbers);
        validateBonusNumber(this.bonusNumber, this.winningNumbers);
    }

    private List<Integer> parseWinningNumbers(String winningNumbersInput) {
        if (winningNumbersInput == null || winningNumbersInput.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR);
        }

        return Arrays.stream(winningNumbersInput.split(Seperator))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int parseBonusNumber(String bonusNumberInput) {
        try {
            return Integer.parseInt(bonusNumberInput.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_ERROR);
        }
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_COUNT_ERROR);
        }

        if (winningNumbers.size() != winningNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBERS_ERROR);
        }

        for (int number : winningNumbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(INVALID_WINNING_NUMBER_ERROR);
            }
        }
    }

    private void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_ERROR);
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_ERROR);
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
