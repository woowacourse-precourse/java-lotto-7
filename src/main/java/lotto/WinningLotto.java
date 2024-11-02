package lotto;

import java.util.List;

public class WinningLotto extends Lotto {

    private Integer bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        containBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

}
