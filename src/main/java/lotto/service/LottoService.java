package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.LottoPurchase;
import lotto.dto.LottoResults;
import lotto.model.WinningNumbers;
import lotto.model.Lottos;
import lotto.model.Rank;

public class LottoService {
    private final LottoGenerator lottoGenerator;
    private final RevenueCalculator revenueCalculator;

    public LottoService(LottoGenerator lottoGenerator, RevenueCalculator revenueCalculator) {
        this.lottoGenerator = lottoGenerator;
        this.revenueCalculator = revenueCalculator;
    }

    public LottoResults calculateResults(Lottos lottos, WinningNumbers winningNumbers, LottoPurchase lottoPurchase) {
        List<Rank> ranks = calculateWinnings(lottos, winningNumbers);
        Map<Rank, Integer> rankFrequency = rankCounter(ranks);
        double revenue = calculateRevenue(ranks, lottoPurchase.getAmount());
        return new LottoResults(rankFrequency, revenue);
    }

    public Lottos generateLottos(Integer count) {
        return lottoGenerator.generate(count);
    }

    private List<Rank> calculateWinnings(Lottos lottos, WinningNumbers winningNumbers) {
        return lottos.compareWithWinLotto(winningNumbers);
    }

    private Map<Rank, Integer> rankCounter(List<Rank> ranks) {
        Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
        for (Rank rank : ranks) {
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }
        return rankCounts;
    }

    private double calculateRevenue(List<Rank> ranks, Integer amount) {
        return revenueCalculator.calculate(ranks, amount);
    }
}
