package lotto.model;

import java.util.List;
import java.util.Objects;

public class LottoResult {
    private final List<LottoRank> LottoRanks;
    private final double earningRate;

    public LottoResult(List<LottoRank> lottoRanks, double earningRate) {
        LottoRanks = lottoRanks;
        this.earningRate = earningRate;
    }


    public List<LottoRank> getLottoRanks() {
        return LottoRanks;
    }

    public double getEarningRate() {
        return earningRate;
    }

    public static LottoResult from(PrizeLotto prizeLotto, Lottos lottos) {
        List<LottoRank> lottoRanks = lottos.getLottos().stream()
                .map(lotto -> LottoRank.from(prizeLotto, lotto))
                .filter(Objects::nonNull)
                .toList();
        int spendMoney = lottos.size() * 1000;
        long totalPrizeMoney = getTotalPrizeMoney(lottoRanks);
        double earningRate = calculateEarningRate(totalPrizeMoney, spendMoney);
        return new LottoResult(lottoRanks, earningRate);
    }

    private static long getTotalPrizeMoney(List<LottoRank> lottoRanks) {
        return lottoRanks.stream().mapToLong(LottoRank::getPrizeMoney).sum();
    }

    private static double calculateEarningRate(long totalPrizeMoney, int spendMoney) {
        return ((double) totalPrizeMoney / (double) spendMoney) * 100;
    }
}
