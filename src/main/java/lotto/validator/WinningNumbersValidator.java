package lotto.validator;

import java.util.List;

public class WinningNumbersValidator implements Validator {
    private static final String WINNING_NUMBERS_COUNT_NOT_SIX = "[ERROR] 당첨 번호는 6개를 입력해 주세요.";
    private static final String WINNING_NUMBERS_OUT_OF_RANGE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String WINNING_NUMBERS_DUPLICATED = "[ERROR] 당첨 번호가 중복되었습니다.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int FIXED_SIZE = 6;
    private final List<Integer> winningNumbers;

    public WinningNumbersValidator(List<Integer> winningNumbers) {
        this.winningNumbers = List.copyOf(winningNumbers);
    }

    @Override
    public void validate() throws IllegalArgumentException {
        validateWinningNumbersCountSix();
        validateWinningNumbersInRange();
        validateWinningNumbersDuplication();
    }

    private void validateWinningNumbersCountSix() throws IllegalArgumentException {
        if (winningNumbers.size() != FIXED_SIZE) {
            throw new IllegalArgumentException(WINNING_NUMBERS_COUNT_NOT_SIX);
        }
    }

    private void validateWinningNumbersInRange() throws IllegalArgumentException {
        winningNumbers.forEach(number -> {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(WINNING_NUMBERS_OUT_OF_RANGE);
            }
        });
    }

    private void validateWinningNumbersDuplication() throws IllegalArgumentException {
        if (winningNumbers.stream().distinct().count() != winningNumbers.size()) {
            throw new IllegalArgumentException(WINNING_NUMBERS_DUPLICATED);
        }
    }
}
