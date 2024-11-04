package lotto.lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.common.util.IdHolder;
import lotto.lotto.domain.value.LottoRank;
import lotto.lotto.service.LottoRankCalculator;

public class LottoResults {

    private final List<LottoResult> results;
    private final String id;

    private LottoResults(List<LottoResult> results, String id) {
        this.results = results;
        this.id = id;
    }

    public static LottoResults of(List<LottoResult> results) {
        return new LottoResults(results, IdHolder.generateID());
    }

    public LottoResults updateAllLottoRanks(LottoRankCalculator lottoRankCalculator, LottoWinning lottoWinning) {
        List<LottoResult> updatedResults = new ArrayList<>();
        for (LottoResult result : results) {
            LottoRank rank = lottoRankCalculator.calculateRank(result.getLotto(), lottoWinning);
            updatedResults.add(result.updateLottoRank(rank));
        }
        return new LottoResults(updatedResults, id);
    }

    public long calculateTotalWinningAmount() {
        return results.stream().map(lottoResult -> lottoResult.getLottoRank().getValue()).reduce(0L, Long::sum);
    }

    public Map<LottoRank, Long> getWinningInfo() {
        Map<LottoRank, Long> rankMap = new EnumMap<>(LottoRank.class);
        List<LottoRank> list = results.stream().map(LottoResult::getLottoRank).toList();
        for (LottoRank rank : list) {
            rankMap.put(rank, rankMap.getOrDefault(rank, 0L) + 1);
        }
        return rankMap;
    }

    public List<LottoResult> getResults() {
        return results;
    }

    public String getId() {
        return id;
    }

}