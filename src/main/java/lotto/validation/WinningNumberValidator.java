package lotto.validation;

import java.util.List;

public class WinningNumberValidator {

    private static final int MAX_NUMBER_RANGE = 45;
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_LOTTO_NUMBER_COUNT = 6;

    private WinningNumberValidator() {
    }

    public static void validateRange(List<Integer> winningNumbers) {

        for (Integer winningNumber : winningNumbers) {
            if (winningNumber > MAX_NUMBER_RANGE || winningNumber < MIN_NUMBER_RANGE) {
                throw new IllegalArgumentException("당첨 번호는 1~45 사이의 숫자를 입력해야 합니다.");
            }
        }
    }

    public static void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != MAX_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 6개까지 입력 가능합니다.");
        }
    }

}
