package lotto.domain.entity;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.vo.BonusNumber;

public class WinningLotto {
    private Lotto lotto;
    private BonusNumber bonus;

    private WinningLotto(List<Integer> numbers, BonusNumber bonus) {
        lotto = new Lotto(numbers);
        this.bonus = bonus;
    }

    public static WinningLotto of(String inputNumbers, String inputBonus) {

        return new WinningLotto(new ArrayList<Integer>(), new BonusNumber(inputBonus));
    }

}
