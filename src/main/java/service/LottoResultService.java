package service;

import lotto.constant.LottoConstant;
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

    public double getProfitRate(Map<LottoRank, Integer> result, int publiedLottoNumber){
        double profit = getProfit(result);
        double money = publiedLottoNumber * LottoConstant.LOTTO_PRICE;
        return (profit/money)*100;
    }

    public double getProfit(Map<LottoRank, Integer> result){
        double profit = 0;

        for (Map.Entry<LottoRank, Integer> resultEntry : result.entrySet()) {
            LottoRank rank = resultEntry.getKey();
            int count = resultEntry.getValue();
            profit += rank.getReward() * count;
        }
        return profit;
    }
}
