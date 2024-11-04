package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public LottoMachine(List<Integer> numbers, Integer bonusNumber) {
        this.numbers = new ArrayList<>(numbers);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumber() {
        return new ArrayList<>(numbers);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
