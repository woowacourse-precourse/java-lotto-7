package lotto.model;

import static lotto.Constants.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;

public record LottoResult(List<LottoPrize> prizes, double rateOfReturn) {

    public static LottoResult of(WinningNumbers winningNumbers, List<Lotto> lottos) {
        List<LottoPrize> prizes = new ArrayList<>();

        for (Lotto lotto : lottos) {
            long matchCount = lotto.getMatchCount(winningNumbers.lotto());
            boolean isBonusBallMatched = lotto.contains(winningNumbers.bonusBall());

            LottoPrize.of(matchCount, isBonusBallMatched).ifPresent(prizes::add);
        }
        int purchaseAmount = lottos.size() * LOTTO_PRICE;
        double rateOfReturn = rateOfReturn(prizes, purchaseAmount);

        return new LottoResult(prizes, rateOfReturn);
    }

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

    private static double rateOfReturn(List<LottoPrize> prizes, int cost) {
        return (revenue(prizes) / cost) * 100;
    }

    private static double revenue(List<LottoPrize> prizes) {
        return prizes.stream()
                .mapToDouble(LottoPrize::getMoney)
                .sum();
    }
}
