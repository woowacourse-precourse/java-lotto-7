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
        int matchCount = 0;
        boolean matchBonus = false;
        for (int i = 0; i < 6; i++) {
            if (lotto.getNumbers().get(i) == targetNumbers.get(i)) {
                matchCount++;
                continue;
            }
            if (targetNumbers.get(i) == bonusNumber) {
                matchBonus = true;
            }
        }
        return RankPrice.of(matchCount, matchBonus);
    }
}
