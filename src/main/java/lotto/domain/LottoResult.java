package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.enums.LottoRank;

public class LottoResult {
    private final Map<LottoRank, Integer> rankCount;
    private final double lottoProfitRate;

    private LottoResult(List<LottoRank> lottoRanks, double lottoProfitRate) {
        this.rankCount = new HashMap<>();
        this.lottoProfitRate = lottoProfitRate;
        initRankCount();
        makeRankCount(lottoRanks);
    }

    public static LottoResult ofRanksAndProfitRate(List<LottoRank> lottoRanks, double lottoProfitRate) {
        return new LottoResult(lottoRanks, lottoProfitRate);
    }

    private void initRankCount() {
        Arrays.stream(LottoRank.values())
                .forEach(lottoRank -> rankCount.put(lottoRank, 0));
    }

    private void makeRankCount(List<LottoRank> lottoRanks) {
        lottoRanks.stream()
                .forEach(lottoRank -> rankCount.put(lottoRank, rankCount.get(lottoRank) + 1));
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
