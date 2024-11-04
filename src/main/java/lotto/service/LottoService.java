package lotto.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.dto.LottoPurchaseDTO;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.Lottos;
import lotto.model.WinningLotto;

public class LottoService {
    public Map<Integer, Boolean> sameNumberCounts(Lottos lottos, WinningLotto winningLotto, LottoPurchaseDTO lottoPurchaseDTO) {
        Map<Integer, Boolean> matchedResults = new HashMap<>();
        for (Lotto lotto : lottos) {
            Map<Integer, Boolean> result = lotto.sameNumbersCount(winningLotto, lottoPurchaseDTO.getBonusNumber());
            matchedResults.putAll(result);
        }
        return matchedResults;
    }

    public List<String> calculateResults(Map<Integer, Boolean> matchedResults) {
        List<String> results = new ArrayList<>();

        for (Map.Entry<Integer, Boolean> entry : matchedResults.entrySet()) {
            int matchedCount = entry.getKey();
            boolean matchedBonus = entry.getValue();

            LottoRank rank = LottoRank.lottoResult(matchedCount, matchedBonus);

            if (rank != null) {
                results.add(rank.getMessage());
            }
        }

        return results;
    }
}
