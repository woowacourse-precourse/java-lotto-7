package lotto.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.common.Constants;
import lotto.dto.LottoPurchaseDTO;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.Lottos;
import lotto.model.WinningLotto;

public class LottoService {

    private int totalLottoCount;
    private int totalLottoPrice;
    private int totalPrize;

    private Map<LottoRank, Integer> rankCountMap = new HashMap<>();

    public Map<Integer, Boolean> sameNumberCounts(Lottos lottos, WinningLotto winningLotto, LottoPurchaseDTO lottoPurchaseDTO) {
        Map<Integer, Boolean> matchedResults = new HashMap<>();
        for (Lotto lotto : lottos) {
            Map<Integer, Boolean> result = lotto.sameNumbersCount(winningLotto, lottoPurchaseDTO.getBonusNumber());
            matchedResults.putAll(result);
            this.totalLottoCount += result.size();
            this.totalLottoPrice += result.size() * Constants.LOTTO_PRICE;
        }
        return matchedResults;
    }

    public List<String> calculateResults(Map<Integer, Boolean> matchedResults) {
        List<String> results = new ArrayList<>();

        for (Entry<Integer, Boolean> entry : matchedResults.entrySet()) {
            int matchedCount = entry.getKey();
            boolean matchedBonus = entry.getValue();

            LottoRank rank = LottoRank.lottoResult(matchedCount, matchedBonus);

            if (rank != null) {
                results.add(rank.getMessage());
                this.totalPrize += rank.getPrize();

                rankCountMap.put(rank, rankCountMap.getOrDefault(rank, 0) + 1);
            }
        }

        return results;
    }

    public double calculateProfit() {
        if (totalLottoPrice == 0) {
            return 0;
        }
        return this.totalPrize / (double)totalLottoPrice * 100;
    }

    public Map<LottoRank, Integer> getRankCount() {
        return rankCountMap;
    }
}
