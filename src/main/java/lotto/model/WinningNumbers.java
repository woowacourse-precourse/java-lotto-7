package lotto.model;

import lotto.constant.ExceptionMessage;
import lotto.constant.Rule;

public record WinningNumbers(Lotto mainNumbers, int bonusNumber) {
    public WinningNumbers {
        validateBonusNumber(mainNumbers, bonusNumber);
    }

    private void validateBonusNumber(final Lotto mainNumbers, final int bonusNumber) {
        validateRange(bonusNumber);
        validateNotMainNumbers(mainNumbers, bonusNumber);
    }

    private void validateRange(final int number) {
        if (number < Rule.MIN_LOTTO_NUMBER || number > Rule.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_INVALID_RANGE.getMessage());
        }
    }

    private void validateNotMainNumbers(final Lotto mainNumbers, final int bonusNumber) {
        if (mainNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_DUPLICATED_NUMBER.getMessage());
        }
    }

    public Prize checkPrize(final Lotto lotto) {
        int matchedCount = countMatchedCount(lotto);
        boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
        return Prize.getPrize(matchedCount, hasBonus);
    }

    private int countMatchedCount(final Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(mainNumbers.getNumbers()::contains)
                .count();
    }
}
