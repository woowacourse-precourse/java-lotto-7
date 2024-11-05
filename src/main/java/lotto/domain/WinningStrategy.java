package lotto.domain;

import lotto.Lotto;
import lotto.common.LottoGrade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStrategy {

    private final Lotto winningLotto;
    private final int bonus;

    public WinningStrategy(Lotto winningLotto, int bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public Map<LottoGrade, Integer> drawLots(List<Lotto> lots) {
        Map<LottoGrade, Integer> result = new HashMap<>();
        for(Lotto lotto: lots) {
            LottoGrade grade = getGrade(lotto);
            int count = result.getOrDefault(grade, 0);
            result.put(grade, count + 1);
        }
        return result;
    }

    private LottoGrade getGrade(Lotto lotto) {
        int count = winningLotto.duplicatesNumber(lotto);
        boolean includeBonus = lotto.containNumber(bonus);

        return LottoGrade.getGrade(count, includeBonus);
    }
}
