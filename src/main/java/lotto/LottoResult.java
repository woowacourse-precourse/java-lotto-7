package lotto;

import java.util.List;

public record LottoResult(List<LottoPrize> prizes) {

    @Override
    public List<LottoPrize> prizes() {
        return List.copyOf(prizes);
    }

    public List<LottoPrize> getPrizeFor(int matchCount) {
        return getPrizeFor(matchCount, false);
    }

    public List<LottoPrize> getPrizeFor(int matchCount, boolean isBonusBallMatched) {
        return this.prizes.stream()
                .filter(prize -> prize.isMatched(matchCount, isBonusBallMatched))
                .toList();
    }

    public List<LottoPrize> getPrizeFor(LottoPrize prize) {
        return prizes.stream()
                .filter(prize::equals)
                .toList();
    }

    public double rateOfReturn(int cost) {
        return (revenue() / cost) * 100;
    }

    private double revenue() {
        return prizes.stream()
                .mapToDouble(LottoPrize::getMoney)
                .sum();
    }
}
