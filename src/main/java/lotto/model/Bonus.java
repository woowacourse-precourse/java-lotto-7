package lotto.model;

import java.util.List;
import lotto.message.ExceptionMessage;

public class Bonus {
    private final int number;

    public Bonus(List<Integer> winningNumbers, int number) {
        validateRange(number);
        validateOverlap(winningNumbers, number);

        this.number = number;
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOverlap(List<Integer> winningNumbers, int bonusNumber) {
        for (int number : winningNumbers) {
            if (number == bonusNumber) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_BONUS_OVERLAP.getMessage());
            }
        }
    }

    public int getNumber() {
        return number;
    }
}
