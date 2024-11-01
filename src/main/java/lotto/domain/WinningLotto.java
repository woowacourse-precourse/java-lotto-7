package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.constant.RankPrice;

public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public RankPrice getRank(Lotto target) {
        List<Integer> targetNumbers = target.getNumbers();
        boolean matchBonus = false;
        Set<Integer> set = new HashSet<>();
        set.addAll(lotto.getNumbers());
        int matchCount = (int)targetNumbers.stream()
            .filter(number -> !set.add(number))
            .count();
        if (!set.add(bonusNumber)) {
            matchBonus = true;
        }
        return RankPrice.of(matchCount, matchBonus);
    }
}
