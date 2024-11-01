package lotto.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.lotto.domain.value.LottoRank;
import lotto.lotto.service.LottoRankCalculator;

public record LottoResults(List<LottoResult> results) {

    public LottoResults updateAllLottoRanks(LottoRankCalculator lottoRankCalculator, LottoWinning lottoWinning) {
        List<LottoResult> updatedResults = new ArrayList<>();
        for (LottoResult result : results) {
            LottoRank rank = lottoRankCalculator.calculateRank(result.getLotto(), lottoWinning);
            updatedResults.add(result.updateLottoRank(rank));
        }
        return new LottoResults(updatedResults);
    }
}