package lotto.domain;

import java.util.List;

public class Winning {
    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public Winning(List<Integer> numbers, Integer bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

}
