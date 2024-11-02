package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private List<LottoPrize> prize;

    public LottoResult(List<LottoPrize> prize) {
        this.prize = prize;
    }

    public double rateOfReturn(int purchaseAmount) {
        long earn = prize.stream()
                .mapToLong(LottoPrize::getPriceValue)
                .sum();

        return (double) earn / purchaseAmount * 100.0;
    }

    public long prizeCount(LottoPrize prize) {
        return this.prize.stream()
                .filter(prize::equals)
                .count();
    }

}
