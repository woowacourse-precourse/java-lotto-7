package lotto.domain;

import java.util.List;

public class Winning {
    private final List<Integer> winningNumbers;

    private Winning(List<Integer> numbers) {
        this.winningNumbers = numbers;
    }

    public static Winning create(List<Integer> numbers) {
        return new Winning(numbers);
    }

    public void existByBonusNumber(int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 동일한 번호가 있습니다.");
        }
    }

    public boolean compareTo(Integer integer) {
        return winningNumbers.contains(integer);
    }
}
