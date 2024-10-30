package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoRanks;

public class LottoService {

    public Map<LottoRank, Integer> evaluateLottos(Lotto winninglotto, int bonusNumber, List<Lotto> lottos) {
        LottoRanks lottoRanks = new LottoRanks();

        for (Lotto lotto : lottos) {
            int matchingCount = getMatchingCount(winninglotto, lotto);
            boolean bonusMatched = isBonusNumberMatched(lotto, bonusNumber);
            LottoRank.findBy(matchingCount, bonusMatched)
                    .ifPresent(lottoRanks::add);
        }

        return lottoRanks.getRanks();
    }

    private int getMatchingCount(Lotto winninglotto, Lotto lotto) {
        return winninglotto.calculateMatchingCount(lotto);
    }

    private boolean isBonusNumberMatched(Lotto lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

}
