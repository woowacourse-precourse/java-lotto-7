package lotto.statistics;

import java.util.List;

public record DrawResultSheet(List<Integer> winningCount) {

    private static final List<WinningRule> WINNING_RULES = List.of(WinningRule.values());
    private static final int MIN_WINNING_COUNT_INDEX = 3;
    private static final int MAX_WINNING_COUNT_INDEX = 7;
    private static final String DRAW_RESULT_HEADER = "당첨 통계";
    private static final String HORIZONTAL_LINE = "---";
    private static final String WINNING_COUNT_MESSAGE_FORMAT = "%s - %d개";

    public void printDrawResult() {
        System.out.println();
        System.out.println(DRAW_RESULT_HEADER);
        System.out.println(HORIZONTAL_LINE);
        for (int i = MIN_WINNING_COUNT_INDEX; i <= MAX_WINNING_COUNT_INDEX; i++) {
            String prizeMessage = WINNING_RULES.get(i - MIN_WINNING_COUNT_INDEX).getPrizeMessage();
            System.out.printf(WINNING_COUNT_MESSAGE_FORMAT, prizeMessage, winningCount.get(i));
            System.out.println();
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
