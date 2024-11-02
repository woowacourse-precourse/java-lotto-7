package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.Prize;

public class WinningNumbers {
    private final Lotto numbers;
    private final int bonusNumber;

    public WinningNumbers(Lotto numbers, int bonusNumber) {
        this.numbers = numbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Prize checkPrize(Lotto myLotto) {
        List<Integer> matchedNumbers = new ArrayList<>(myLotto.getNumbers());
        matchedNumbers.retainAll(numbers.getNumbers());

        int matchedCount = matchedNumbers.size();
        boolean hasBonus = myLotto.getNumbers().contains(bonusNumber);
        return Prize.getPrize(matchedCount, hasBonus);
    }

    private void validateBonusNumber(int number) {
        validateRange(number);
        validateNotWinningNumbers(number);
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNotWinningNumbers(int number) {
        if (numbers.getNumbers().contains(number)) {
            throw new IllegalArgumentException();
        }
    }
}
