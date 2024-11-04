package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.Lotto;
import lotto.constants.OutputMessages;

public class Result {
    public static final int PERCENTAGE_FACTOR = 100;

    private final Map<PrizeLevel, Integer> resultMap = new EnumMap<>(PrizeLevel.class);
    private final List<Lotto> lottos;
    private final Set<Integer> winningNumbers;
    private final int bonusNumber;

    public Result(List<Lotto> lottos, Set<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        
        initializeResultMap();
    }

    private void initializeResultMap() {
        for (PrizeLevel level : PrizeLevel.values()) {
            resultMap.put(level, 0);
        }
    }

    public void calculate() {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(winningNumbers);
            boolean bonusMatch = lotto.hasBonusNumber(bonusNumber);

            determinePrizeLevel(matchCount, bonusMatch);
        }
    }

    private void determinePrizeLevel(int matchCount, boolean bonusMatch) {
        for (PrizeLevel level : PrizeLevel.values()) {
            if (isMatchingPrizeLevel(matchCount, bonusMatch, level)) {
                incrementResult(level);
                return;
            }
        }
    }

    private static boolean isMatchingPrizeLevel(int matchCount, boolean bonusMatch, PrizeLevel level) {
        return level.getMatchCount() == matchCount && level.isBonusMatch() == bonusMatch;
    }

    private void incrementResult(PrizeLevel level) {
        resultMap.put(level, resultMap.get(level) + 1);
    }

    public void printResult(int purchaseAmount) {
        System.out.println();
        System.out.println(OutputMessages.WINNING_STATISTICS_TITLE);
        System.out.println(OutputMessages.SEPARATOR_LINE);

        long totalPrize = calculateTotalPrize();

        printResultCounts();

        double rateOfReturn = (double) totalPrize / purchaseAmount * PERCENTAGE_FACTOR;
        System.out.printf((OutputMessages.TOTAL_RATE_OF_RETURN) + "%n", String.format("%.1f", rateOfReturn));
    }

    private long calculateTotalPrize() {
        long totalPrize = 0;
        for (Map.Entry<PrizeLevel, Integer> entry : resultMap.entrySet()) {
            PrizeLevel level = entry.getKey();
            int count = entry.getValue();

            totalPrize += level.getPrizeMoney() * count;
        }
        return totalPrize;
    }

    private void printResultCounts() {
        for (PrizeLevel level : PrizeLevel.values()) {
            int count = resultMap.get(level);

            System.out.printf((OutputMessages.PRIZE_COUNT_FORMAT) + "%n", level.getDisplayName(), count);
        }
    }
}
