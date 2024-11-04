package lotto.winning;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.common.constant.RankConstant;
import lotto.common.model.Lotto;

public class CheckingWinningService {



    public Map<RankConstant, Integer> calculateRanks(List<Integer> numberOfMatches) {
        int firstRank = Collections.frequency(numberOfMatches, 6);
        int secondRank = Collections.frequency(numberOfMatches, 10);
        int thirdRank = Collections.frequency(numberOfMatches, 5);
        int fourthRank = Collections.frequency(numberOfMatches, 4);
        int fifthRank = Collections.frequency(numberOfMatches, 3);

        Map<RankConstant, Integer> ranks = new HashMap<>(5);
        ranks.put(RankConstant.FIRSTRANK, firstRank);
        ranks.put(RankConstant.SECONDRANK, secondRank);
        ranks.put(RankConstant.THIRDRANK, thirdRank);
        ranks.put(RankConstant.FOURTHRANK, fourthRank);
        ranks.put(RankConstant.FIFTHRANK, fifthRank);

        return ranks;
    }

    public double calculateRateOfReturn(Map<RankConstant, Integer> ranks, int payment) {
        double sum = 0;
        for (RankConstant rankConstant : ranks.keySet()) {
            sum += rankConstant.getAmount() * ranks.get(rankConstant);
        }
        sum /= payment;
        sum *= 100;

        return Math.round(sum * 100) / 100.0;
    }
}
