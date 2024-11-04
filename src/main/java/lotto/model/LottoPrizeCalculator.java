package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.lottoprize.LottoPrize;
import lotto.model.lottoprize.LottoPrizes;

public class LottoPrizeCalculator {
    private static final int YIELD_SCALE = 1;
    private static final int DIVISION_SCALE = 3;
    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);
    private static final String PRIZE_STATISTICS_FORMAT = "%s%d개";

    private final LottoPrizes lottoPrizes;

    public LottoPrizeCalculator(LottoPrizes lottoPrizes) {
        this.lottoPrizes = lottoPrizes;
    }

    public String calculateYield(int purchaseAmount) {
        int totalPrizeAmount = calculateTotalPrizeAmount();

        return calculatePercentage(purchaseAmount, totalPrizeAmount);
    }

    public List<String> generateMatchStatistics() {
        return Arrays.stream(LottoPrize.values())
                .filter(this::isPrizeEligible)
                .map(this::formatPrizeStatistics)
                .collect(Collectors.toList());
    }

    private int calculateTotalPrizeAmount() {
        return lottoPrizes.getLottoPrizes()
                .stream()
                .mapToInt(LottoPrize::getPrizeAmount)
                .sum();
    }

    private static String calculatePercentage(int purchaseAmount, int totalPrizeAmount) {
        return BigDecimal.valueOf(totalPrizeAmount)
                .divide(BigDecimal.valueOf(purchaseAmount), DIVISION_SCALE, RoundingMode.HALF_UP)
                .multiply(HUNDRED)
                .setScale(YIELD_SCALE, RoundingMode.HALF_UP)
                .toString();
    }

    private boolean isPrizeEligible(LottoPrize prize) {
        return prize != LottoPrize.NO_PRIZE;
    }


    private String formatPrizeStatistics(LottoPrize prize) {
        long prizeCount = countPrizes(prize);
        return String.format(PRIZE_STATISTICS_FORMAT, prize, prizeCount);
    }

    private long countPrizes(LottoPrize prize) {
        return lottoPrizes.getLottoPrizes().stream()
                .filter(lottoPrize -> lottoPrize == prize)
                .count();
    }
}
