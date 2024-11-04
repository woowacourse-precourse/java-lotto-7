package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPrizes {

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
