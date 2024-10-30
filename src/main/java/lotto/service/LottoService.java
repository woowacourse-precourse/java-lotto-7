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
            int matchingNumberCount = getMatchingNumberCount(winninglotto, lotto);
            boolean bonusMatched = isBonusNumberMatched(lotto, bonusNumber);
            LottoRank.findBy(matchingNumberCount, bonusMatched)
                    .ifPresent(lottoRanks::add);
        }

        return lottoRanks.getRanks();
    }

    private int getMatchingNumberCount(Lotto winninglotto, Lotto lotto) {
        return winninglotto.countMatchingNumbers(lotto);
    }

    private boolean isBonusNumberMatched(Lotto lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

}
