package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {

    private final Map<LottoResult, Integer> lottoResultMap = new HashMap<>();
    private final List<Lotto> lottos;

    public LottoManager(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void getLottoResultFrom(Lotto winningLotto, Bonus bonus) {
        lottos.forEach(lotto -> compareWith(winningLotto, bonus, lotto));
    }

    private void compareWith(Lotto winningLotto, Bonus bonus, Lotto lotto) {
        int matchingCount = findMatchingCount(winningLotto, lotto);
        boolean doesBonusMatch = lotto.hasBonus(bonus);
        LottoResult lottoResult = LottoResult.getLottoResult(matchingCount, doesBonusMatch);
        lottoResultMap.put(lottoResult, lottoResultMap.getOrDefault(lottoResult, 0) + 1);
    }

    private int findMatchingCount(Lotto winningLotto, Lotto lotto) {
        return winningLotto.countSameNumbers(lotto);
    }
}
