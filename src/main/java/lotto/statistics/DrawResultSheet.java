package lotto.statistics;

import java.util.List;

public record DrawResultSheet(List<Integer> winningCount) {

    private static final List<WinningRule> WINNING_RULES = List.of(WinningRule.values());
    private static final int MIN_WINNING_COUNT_INDEX = 3;
    private static final int MAX_WINNING_COUNT_INDEX = 7;

    public void printDrawResult() {
        for (int i = MIN_WINNING_COUNT_INDEX; i <= MAX_WINNING_COUNT_INDEX; i++) {
            String prizeMessage = WINNING_RULES.get(i - MIN_WINNING_COUNT_INDEX).getPrizeMessage();
            System.out.println(prizeMessage + " - " + winningCount.get(i) + "개");
        }
    }

    public long calculateTotalPrizeAmount() {
        long totalPrizeAmount = 0L;

        for (int i = MIN_WINNING_COUNT_INDEX; i <= MAX_WINNING_COUNT_INDEX; i++) {
            long prizeAmount = WINNING_RULES.get(i - MIN_WINNING_COUNT_INDEX).getPrizeAmount();
            totalPrizeAmount += prizeAmount * winningCount.get(i);
        }
        return totalPrizeAmount;
    }
}
