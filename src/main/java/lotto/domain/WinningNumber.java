package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.message.ErrorMessage;

public class WinningNumber {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
