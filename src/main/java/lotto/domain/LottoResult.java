package lotto.domain;

import java.util.Map;
import lotto.enums.LottoRank;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCount;
    private final double lottoProfitRate;

    private LottoResult(Map<LottoRank, Integer> rankCount, double lottoProfitRate) {
        this.rankCount = rankCount;
        this.lottoProfitRate = lottoProfitRate;
    }

    public static LottoResult ofRankCountAndProfitRate(Map<LottoRank, Integer> rankCount, double lottoProfitRate) {
        return new LottoResult(rankCount, lottoProfitRate);
    }

    public Map<LottoRank, Integer> getRankCount() {
        return rankCount;
    }

    public double getLottoProfitRate() {
        return lottoProfitRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoResult that = (LottoResult) o;

        if (Double.compare(that.lottoProfitRate, lottoProfitRate) != 0) {
            return false;
        }
        return rankCount.equals(that.rankCount);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = rankCount.hashCode();
        temp = Double.doubleToLongBits(lottoProfitRate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
