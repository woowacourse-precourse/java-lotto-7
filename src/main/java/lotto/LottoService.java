package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    private final LottoGenerator lottoGenerator;
    public final RevenueCalculator revenueCalculator;

    public LottoService(LottoGenerator lottoGenerator, RevenueCalculator revenueCalculator) {
        this.lottoGenerator = lottoGenerator;
        this.revenueCalculator = revenueCalculator;
    }

    public LottoResults calculateResults(Lottos lottos, WinningNumbers winningNumbers, Integer count) {
        List<Rank> ranks = calculateWinnings(lottos, winningNumbers);
        Map<Rank, Integer> rankFrequency = rankCounter(ranks);
        double revenue = calculateRevenue(ranks, count);
        return new LottoResults(rankFrequency, revenue);
    }

    public Lottos createLottos(Integer count) {
        return new Lottos(
                IntStream.range(0, count)
                        .mapToObj(i -> lottoGenerator.createLotto())
                        .collect(Collectors.toList()));
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

    public double calculateRevenue(List<Rank> ranks, Integer count) {
        return revenueCalculator.calculate(ranks, count);
    }
}
