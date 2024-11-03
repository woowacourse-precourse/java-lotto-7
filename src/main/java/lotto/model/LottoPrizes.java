package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPrizes {

    private final List<LottoPrize> lottoPrizes;

    public LottoPrizes(List<LottoPrize> lottoPrizes) {
        this.lottoPrizes = lottoPrizes;
    }

    public String calculateYield(int lottoBudget) {
        int totalPrizeAmount = lottoPrizes.stream().mapToInt(LottoPrize::getPrizeAmount).sum();

        BigDecimal yield = BigDecimal.valueOf(totalPrizeAmount)
                .divide(BigDecimal.valueOf(lottoBudget), 3, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(1, RoundingMode.HALF_UP);

        return yield.toString();
    }

    public List<String> calculateMatchStatistics() {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize != LottoPrize.NO_PRIZE)
                .map(prize -> {
                    long count = lottoPrizes.stream()
                            .filter(p -> p == prize)
                            .count();
                    return prize.toString() + count + "개";
                })
                .collect(Collectors.toList());
    }
}
