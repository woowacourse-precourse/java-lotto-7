package lotto.domain.winning;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.ui.dto.WinningCountByPrize;

public class WinningStatistics {

    private final Map<LottoRank, Integer> result;

    public WinningStatistics() {
        this.result = new HashMap<>();
    }

    public void addWinCountByRank(LottoRank lottoRank) {
        result.put(lottoRank, getWinningCountByRank(lottoRank) + 1);
    }

    private int getWinningCountByRank(LottoRank lottoRank) {
        return result.getOrDefault(lottoRank, 0);
    }

    public BigDecimal getTotalPrize() {
        BigDecimal total = BigDecimal.ZERO;
        for (LottoRank lottoRank : result.keySet()) {
            total = total.add(calculateTotalPrizeByRank(lottoRank));
        }
        return total;
    }

    private BigDecimal calculateTotalPrizeByRank(LottoRank lottoRank) {
        return BigDecimal.valueOf(lottoRank.getPrizeMoney())
                .multiply(BigDecimal.valueOf(getWinningCountByRank(lottoRank)));
    }

    public List<WinningCountByPrize> getWinningCountByPrizes() {
        return Arrays.stream(LottoRank.values())
                .filter(LottoRank::isWinning)
                .sorted((r1, r2) -> Integer.compare(r2.getRank(), r1.getRank()))
                .map(rank -> WinningCountByPrize.of(rank, getWinningCountByRank(rank)))
                .toList();
    }

}
