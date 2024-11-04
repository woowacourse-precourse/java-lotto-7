package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private final LottoGenerator lottoGenerator;
    public final RevenueCalculator revenueCalculator;

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

    public Lottos createLottos(Integer count) {
        return lottoGenerator.generate(count);
    }

    public List<Rank> calculateWinnings(Lottos lottos, WinningNumbers winningNumbers) {
        return lottos.compareWithWinLotto(winningNumbers);
    }

    public Map<Rank, Integer> rankCounter(List<Rank> ranks) {
        Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
        for (Rank rank : ranks) {
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }
        return rankCounts;
    }

    public double calculateRevenue(List<Rank> ranks, Integer amount) {
        return revenueCalculator.calculate(ranks, amount);
    }
}
