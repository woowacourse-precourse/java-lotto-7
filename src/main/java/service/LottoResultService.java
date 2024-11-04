package service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultService {

    public LottoResultService() {}

    public Map<LottoRank, Integer> getLottoResult(List<Lotto> lottos, Lotto winningLotto, Integer bonusNumber){
        Map<LottoRank, Integer> result = new HashMap<>();
        for(Lotto lotto : lottos){
            Integer matchCount = lotto.getMatchCount(winningLotto);
            boolean bonusmatch = lotto.getBonusMatch(bonusNumber);
            LottoRank rank = LottoRank.getRank(matchCount, bonusmatch);
            result.merge(rank, 1, Integer::sum);
        }
        return result;
    }
}
