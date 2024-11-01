package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class WinningNumbers {
    private final Lotto numbers;
    private final int bonusNumber;

    public WinningNumbers(Lotto numbers, int bonusNumber) {
        this.numbers = numbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int checkPrize(Lotto myLotto) {
        List<Integer> matchedNumbers = new ArrayList<>(myLotto.getNumbers());
        matchedNumbers.retainAll(numbers.getNumbers());

        int matchedNumberSize = matchedNumbers.size();
        if (matchedNumberSize == 6) {
            return 1;
        }
        if (matchedNumberSize == 5) {
            if (myLotto.getNumbers().contains(bonusNumber)) {
                return 2;
            }
            return 3;
        }
        if (matchedNumberSize == 4) {
            return 4;
        }
        if (matchedNumberSize == 3) {
            return 2;
        }

        return 0;
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
