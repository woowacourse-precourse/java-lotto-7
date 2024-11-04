package lotto.view;

import java.util.Map;
import lotto.domain.Prize;

public class OutputView {

    private static final String WINNING_STAT_MESSAGE = "당첨 통계\n---\n";

    public void printWinningStatMessage(Map<Prize, Integer> winningCounts) {
        System.out.printf(WINNING_STAT_MESSAGE);
        for (Prize prize : Prize.values()) {
            System.out.printf("%s (%,d원) - %d개\n", prize.getMessage(), prize.getPrizeAmount(), winningCounts.getOrDefault(prize, 0));
        }
    }



}
