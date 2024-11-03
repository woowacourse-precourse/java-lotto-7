package lotto.domain;

import java.util.List;

public class Winning extends Lotto {
    private final Integer bonusNumber;

    public Winning(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return super.getNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

}
