package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinningResult {
    private final List<LottoRank> result;

    public WinningResult(List<LottoRank> result) {
        this.result = result;
    }

    public List<LottoRank> get() {
        return Collections.unmodifiableList(result);
    }

    public double calculateProfitRate(int purchaseAmount) {
        double totalWinning = 0.0;
        for (final LottoRank lottoRank : result) {
            totalWinning += lottoRank.getWinnings();
        }
        return totalWinning / purchaseAmount * 100.0;
    }
}
