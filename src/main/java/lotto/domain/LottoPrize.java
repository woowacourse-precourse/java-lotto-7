package lotto.domain;

public class LottoPrize {
    private final int lottoPrize;

    public LottoPrize(LottoRank lottoRank) {
        this.lottoPrize = calculateLottoPrize(lottoRank);
    }

    public int getLottoPrize() {
        return lottoPrize;
    }

    private int calculateLottoPrize(LottoRank lottoRank) {
        return lottoRank.getLottoRank().entrySet().stream()
                .mapToInt(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
    }
}
