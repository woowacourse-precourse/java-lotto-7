package lotto.domain.number;

import lotto.global.constant.LottoConstant;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

import java.util.List;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(final int input, final WinningNumbers winningNumbers) {
        Validator.validate(input, winningNumbers);
        this.bonusNumber = input;
    }

    public static BonusNumber from(final int input, final WinningNumbers winningNumbers) {
        return new BonusNumber(input, winningNumbers);
    }

    public boolean contains(final List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }

    private static class Validator {
        private static void validate(final int number, final WinningNumbers winningNumbers) {
            validateRange(number);
            validateDuplication(number, winningNumbers);
        }

        private static void validateRange(final int number) {
            if (number < LottoConstant.MIN_LOTTO_NUMBER || number > LottoConstant.MAX_LOTTO_NUMBER) {
                throw LottoException.from(ErrorMessage.INVALID_LOTTO_RANGE);
            }
        }

        private static void validateDuplication(final int number, final WinningNumbers winningNumbers) {
            if (winningNumbers.contains(number)) {
                throw LottoException.from(ErrorMessage.DUPLICATE_BONUS_NUMBER);
            }
        }
    }
}