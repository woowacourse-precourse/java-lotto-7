package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.constant.prize.Prize;

public record WinningNumbers(Lotto numbers, int bonusNumber) {
    public WinningNumbers {
        validateBonusNumber(numbers, bonusNumber);
    }

    private void validateBonusNumber(final Lotto numbers, final int bonusNumber) {
        validateRange(bonusNumber);
        validateNotWinningNumbers(numbers, bonusNumber);
    }

    private void validateRange(final int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_INVALID_RANGE.getMessage());
        }
    }

    private void validateNotWinningNumbers(final Lotto numbers, final int bonusNumber) {
        if (numbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_DUPLICATED_NUMBER.getMessage());
        }
    }

    public Prize checkPrize(final Lotto myLotto) {
        List<Integer> matchedNumbers = new ArrayList<>(myLotto.getNumbers());
        matchedNumbers.retainAll(numbers.getNumbers());

        int matchedCount = matchedNumbers.size();
        boolean hasBonus = myLotto.getNumbers().contains(bonusNumber);
        return Prize.getPrize(matchedCount, hasBonus);
    }
}
