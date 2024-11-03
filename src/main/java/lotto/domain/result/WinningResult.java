package lotto.domain.result;

import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.lotto.WinningLottos;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    private static final int INCREASE_COUNT = 1;
    private static final int DEFAULT_VALUE = 0;

    private final Map<LottoRank, Integer> lottoResult;
    private final Revenue revenue;

    private WinningResult(final WinningLottos winningLottos, final int purchaseCount) {
        this.lottoResult = calculateRankCount(winningLottos.getWinningLottos());
        this.revenue = createRevenue(purchaseCount);
    }

    public static WinningResult of(final WinningLottos winningLottos, final int purchaseCount) {
        return new WinningResult(winningLottos, purchaseCount);
    }

    private Map<LottoRank, Integer> calculateRankCount(final List<WinningLotto> winningLottos) {
        Map<LottoRank, Integer> result = initializeRankCount();
        for (WinningLotto winningLotto : winningLottos) {
            LottoRank rank = winningLotto.getRank();
            result.put(rank, result.get(rank) + INCREASE_COUNT);
        }
        return result;
    }

    private Map<LottoRank, Integer> initializeRankCount() {
        Map<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            initializeValidRank(rank, result);
        }
        return result;
    }

    private static void initializeValidRank(LottoRank rank, Map<LottoRank, Integer> result) {
        if (rank != LottoRank.NONE) {
            result.put(rank, DEFAULT_VALUE);
        }
    }

    private Revenue createRevenue(final int purchaseCount) {
        return Revenue.of(calculateTotalPrizeAmount(), purchaseCount);
    }

    private int calculateTotalPrizeAmount() {
        return lottoResult.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return Map.copyOf(lottoResult);
    }

    public Revenue getRevenue() {
        return revenue;
    }
}