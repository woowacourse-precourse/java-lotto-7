package lotto.lotto.domain;

import java.util.List;

public class LottoAnswer extends Lotto {
    private final int bonusNumber;

    LottoAnswer(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public static LottoAnswer issue(List<Integer> numbers, int bonusNumber) {
        return new LottoAnswer(numbers, bonusNumber);
    }

    public boolean containsBonus(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
