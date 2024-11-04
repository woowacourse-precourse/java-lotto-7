package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPrizes {
    private static final int YIELD_SCALE = 1;
    private static final int DIVISION_SCALE = 3;
    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);
    private static final String PRIZE_STATISTICS_FORMAT = "%s%d개";

    private final List<LottoPrize> lottoPrizes;
    private final WinningNumbers winningNumbers;

    public LottoPrizes(Lottos lottos, WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
        this.lottoPrizes = getPrizes(lottos);
    }

    private List<LottoPrize> getPrizes(Lottos lottos) {
        return lottos
                .getLottos()
                .stream()
                .map(this::getPrize)
                .toList();
    }

    private LottoPrize getPrize(Lotto lotto) {
        int matchCount = winningNumbers.countMatchingNumbers(lotto);
        boolean containsBonusNumber = winningNumbers.containsNumber(lotto);
        return LottoPrize.getLottoPrize(matchCount, containsBonusNumber);
    }

    public String calculateYield(int purchaseAmount) {
        int totalPrizeAmount = lottoPrizes.stream()
                .mapToInt(LottoPrize::getPrizeAmount)
                .sum();

        BigDecimal yield = calculateYield(totalPrizeAmount, purchaseAmount);
        return yield.toString();
    }

    private BigDecimal calculateYield(int totalPrizeAmount, int lottoBudget) {
        return BigDecimal.valueOf(totalPrizeAmount)
                .divide(BigDecimal.valueOf(lottoBudget), DIVISION_SCALE, RoundingMode.HALF_UP)
                .multiply(HUNDRED)
                .setScale(YIELD_SCALE, RoundingMode.HALF_UP);
    }

    public List<String> calculateMatchStatistics() {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize != LottoPrize.NO_PRIZE)
                .map(this::formatPrizeStatistics)
                .collect(Collectors.toList());
    }

    private String formatPrizeStatistics(LottoPrize prize) {
        long prizeCount = countPrizes(prize);
        return String.format(PRIZE_STATISTICS_FORMAT, prize, prizeCount);
    }

    private long countPrizes(LottoPrize prize) {
        return lottoPrizes.stream()
                .filter(lottoPrize -> lottoPrize == prize)
                .count();
    }
}
