package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.WinningRank;
import lotto.model.Lotto;
import lotto.model.WinningLotto;

public class LottoMatchNumberService {
    private final WinningLotto winningLotto;

    public LottoMatchNumberService(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public Map<WinningRank, Integer> calculateResults(List<Lotto> userLotto) {
        Map<WinningRank, Integer> results = new HashMap<>();

        for (Lotto lotto : userLotto) {
            int matchCount = winningLotto.getMatchCount(lotto);
            boolean bonusMatch = winningLotto.containsBonusNumber(lotto);

            WinningRank rank = WinningRank.valueOf(matchCount, bonusMatch);
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }
        return results;
    }
}
