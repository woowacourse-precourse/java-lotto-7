package lotto.domain.result;

import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.lotto.WinningLottos;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public record WinningResult(
        Map<LottoRank, Integer> lottoResult,
        Revenue revenue
) {
    private static final int INCREASE_COUNT = 1;
    private static final int DEFAULT_VALUE = 0;

    public static WinningResult of(final WinningLottos winningLottos, final int purchaseCount) {
        Map<LottoRank, Integer> lottoResult = calculateRankCount(winningLottos.getWinningLottos());
        Revenue revenue = createRevenue(lottoResult, purchaseCount);
        return new WinningResult(lottoResult, revenue);
    }

    private static Map<LottoRank, Integer> calculateRankCount(final List<WinningLotto> winningLottos) {
        Map<LottoRank, Integer> result = initializeRankCount();
        for (WinningLotto winningLotto : winningLottos) {
            LottoRank rank = winningLotto.getRank();
            result.put(rank, result.get(rank) + INCREASE_COUNT);
        }
        return result;
    }

    private static Map<LottoRank, Integer> initializeRankCount() {
        Map<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            initializeValidRank(rank, result);
        }
        return result;
    }

    private static void initializeValidRank(final LottoRank rank, final Map<LottoRank, Integer> result) {
        if (rank != LottoRank.NONE) {
            result.put(rank, DEFAULT_VALUE);
        }
    }

    private static Revenue createRevenue(final Map<LottoRank, Integer> lottoResult, final int purchaseCount) {
        return Revenue.of(calculateTotalPrizeAmount(lottoResult), purchaseCount);
    }

    private static int calculateTotalPrizeAmount(final Map<LottoRank, Integer> lottoResult) {
        return lottoResult.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    @Override
    public Map<LottoRank, Integer> lottoResult() {
        return Map.copyOf(lottoResult);
    }
}