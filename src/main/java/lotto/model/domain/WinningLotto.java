package lotto.model.domain;

import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;
    private final Integer bonusNumber;

    private WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> numbers, Integer bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
