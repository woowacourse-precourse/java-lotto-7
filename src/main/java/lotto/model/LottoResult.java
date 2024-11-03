package lotto.model;

import static lotto.constant.LottoConstants.PRICE;

import java.util.ArrayList;
import java.util.List;

public record LottoResult(List<LottoPrize> prizes, double rateOfReturn) {
    private static final int PERCENT_FACTOR = 100;

    public static LottoResult of(WinningNumbers winningNumbers, List<Lotto> lottos) {
        List<LottoPrize> prizes = new ArrayList<>();

        for (Lotto lotto : lottos) {
            long matchCount = lotto.getMatchCount(winningNumbers.lotto());
            boolean isBonusBallMatched = lotto.contains(winningNumbers.bonusBall());

            LottoPrize.of(matchCount, isBonusBallMatched).ifPresent(prizes::add);
        }
        int purchaseAmount = lottos.size() * PRICE.getValue();
        double rateOfReturn = rateOfReturn(prizes, purchaseAmount);

        return new LottoResult(prizes, rateOfReturn);
    }

    private static double rateOfReturn(List<LottoPrize> prizes, int cost) {
        return (revenue(prizes) / cost) * PERCENT_FACTOR;
    }

    private static double revenue(List<LottoPrize> prizes) {
        return prizes.stream()
                .mapToDouble(LottoPrize::getMoney)
                .sum();
    }

    @Override
    public List<LottoPrize> prizes() {
        return List.copyOf(prizes);
    }

    public List<LottoPrize> prizeOf(LottoPrize prize) {
        return prizes.stream()
                .filter(prize::equals)
                .toList();
    }
}
