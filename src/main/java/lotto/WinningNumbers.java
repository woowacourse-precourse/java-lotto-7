package lotto;

import static lotto.ErrorMessage.BONUS_NUMBER_IN_WINNING_NUMBERS;
import static lotto.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.ErrorMessage.INVALID_WINNING_NUMBERS_COUNT;
import static lotto.ErrorMessage.NOT_UNIQUE_WINNING_NUMBER;
import static lotto.LottoMachine.LOTTO_NUMBER_COUNT;
import static lotto.LottoMachine.MAX_LOTTO_NUMBER_RANGE;
import static lotto.LottoMachine.MIN_LOTTO_NUMBER_RANGE;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    private WinningNumbers(final List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers of(final List<Integer> winningNumbers) {
        validateWinningNumbersCount(winningNumbers);
        validateWinningNumbersRange(winningNumbers);
        validateUniqueWinningNumber(winningNumbers);
        return new WinningNumbers(winningNumbers);
    }

    public void validateDuplicatedWithBonusNumber(final int bonusNumber) {
        if (contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_IN_WINNING_NUMBERS.getMessage());
        }
    }

    public boolean contains(int lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }

    private static void validateUniqueWinningNumber(final List<Integer> winningNumbers) {
        long distinctCount = winningNumbers.stream()
                .distinct()
                .count();

        if (distinctCount != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(NOT_UNIQUE_WINNING_NUMBER.getMessage());
        }
    }

    private static void validateWinningNumbersRange(final List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            validateLottoNumberRange(number);
        }
    }

    private static void validateLottoNumberRange(final int number) {
        if (number < MIN_LOTTO_NUMBER_RANGE || number > MAX_LOTTO_NUMBER_RANGE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private static void validateWinningNumbersCount(final List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_COUNT.getMessage());
        }
    }
}
