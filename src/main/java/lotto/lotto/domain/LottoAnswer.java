package lotto.lotto.domain;

import java.util.List;

public class LottoAnswer extends Lotto {
    private final int bonusNumber;

    LottoAnswer(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }
}
