package lotto.service.winning;

import static lotto.constant.LottoConstant.PRICE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.Rank;
import lotto.domain.Winning;

public class WinningServiceImpl implements WinningService {

    @Override
    public Winning createWinning(List<Integer> numbers, int bonusNumber) {
        return new Winning(numbers, bonusNumber);
    }

    @Override
    public LottoStatistics getStatistics(LottoPurchase purchase, Winning winning) {
        Map<Lotto, Rank> lottoRanks = purchase.rankLottos(winning);

        Map<Rank, Integer> rankCounts = createRankCountsMap(lottoRanks);
        double profitRate = calculateProfitRate(purchase, lottoRanks);

        return new LottoStatistics(rankCounts, profitRate);
    }

    private static double calculateProfitRate(LottoPurchase purchase, Map<Lotto, Rank> lottoRanks) {
        long totalPrize = lottoRanks.values().stream()
            .mapToLong(Rank::getPrize).sum();
        long totalCost = (long) purchase.count() * PRICE;

        return (double) totalPrize / totalCost * 100.0;
    }

    private static Map<Rank, Integer> createRankCountsMap(Map<Lotto, Rank> lottoRanks) {
        Map<Rank, Integer> rankCounts = new HashMap<>();
        Arrays.stream(Rank.values()).forEach(rank -> rankCounts.put(rank, 0));

        lottoRanks.values()
            .forEach(rank -> rankCounts.put(rank, rankCounts.get(rank) + 1));
        return rankCounts;
    }
}
