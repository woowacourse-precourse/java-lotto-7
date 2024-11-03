package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {

    private final Map<LottoResult, Integer> lottoResultMap = new HashMap<>();
    private final List<Lotto> lottos;

    public LottoManager(List<Lotto> lottos, Lotto winningLotto, Bonus bonus) {
        this.lottos = lottos;
        getLottoResultFrom(winningLotto, bonus);
    }

    public int calculateWinningAmount() {
        return lottoResultMap.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getWinningAmount() * entry.getValue())
                .sum();
    }

    public Map<LottoResult, Integer> getLottoResultMap() {
        return lottoResultMap;
    }

    private void getLottoResultFrom(Lotto winningLotto, Bonus bonus) {
        setLottoResultMap();
        lottos.forEach(lotto -> compareWith(winningLotto, bonus, lotto));
    }

    private void setLottoResultMap() {
        for (LottoResult lottoResult : LottoResult.values()) {
            lottoResultMap.put(lottoResult, 0);
        }
    }

    private void compareWith(Lotto winningLotto, Bonus bonus, Lotto lotto) {
        int matchingCount = findMatchingCount(winningLotto, lotto);
        boolean doesBonusMatch = lotto.hasBonus(bonus);
        LottoResult lottoResult = LottoResult.getLottoResult(matchingCount, doesBonusMatch);
        if (lottoResult != null) {
            lottoResultMap.put(lottoResult, lottoResultMap.get(lottoResult) + 1);
        }
    }

    private int findMatchingCount(Lotto winningLotto, Lotto lotto) {
        return winningLotto.countSameNumbers(lotto);
    }
}
