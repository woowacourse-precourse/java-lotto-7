package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRankDeterminer {
    
    public Map<Lotto, LottoRank> determineLottoRanks(List<Lotto> lottos, Lotto winnerLotto, int bonusNumber) {
        return countMatchingAllLottos(lottos, winnerLotto, bonusNumber);
    }

    private Map<Lotto, LottoRank> countMatchingAllLottos(List<Lotto> lottos, Lotto winnerLotto, int bonusNumber) {
        Map<Lotto, LottoRank> lottoResults = new HashMap<>();

        for (Lotto lotto : lottos) {
            int matchCount = countMatchingSingleLotto(lotto, winnerLotto);
            boolean hasBonusNumber = hasBonusNumberInLotto(lotto, bonusNumber);

            LottoRank matchedRank = LottoRank.findRankByMatching(matchCount, hasBonusNumber);
            lottoResults.put(lotto, matchedRank);
        }
        return lottoResults;
    }

    private boolean hasBonusNumberInLotto(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private int countMatchingSingleLotto(Lotto lotto, Lotto winnerLotto) {
        return (int) lotto.getNumbers().stream()
                .distinct()
                .filter(number -> winnerLotto.getNumbers().contains(number))
                .count();
    }

}
