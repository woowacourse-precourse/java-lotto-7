package lotto.view;

import java.util.List;
import lotto.dto.WinningResult;

public class OutputView {

    private static final String PURCHASED_QUANTITY_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_RESULT_MESSAGE = "\n당첨 통계\n---\n%s";
    private static final String TOTAL_YIELD_MESSAGE = "총 수익률은 %.1f%%입니다.%n";

    public void printPurchasedQuantity(int purchasedQuantity) {
        System.out.printf(PURCHASED_QUANTITY_MESSAGE, purchasedQuantity);
    }

    public void printLottoTickets(List<List<Integer>> lottoTickets) {
        StringBuilder stringBuilder = new StringBuilder();
        for (List<Integer> lottoTicket : lottoTickets) {
            stringBuilder.append(lottoTicket.toString())
                    .append(System.lineSeparator());
        }
        System.out.println(stringBuilder);
    }

    public void printWinningResult(WinningResult winningResult) {
        System.out.printf(WINNING_RESULT_MESSAGE, getWinningStatistics(winningResult));
    }

    private String getWinningStatistics(WinningResult winningResult) {
        return WinningMatchMessage.FIFTH.getMessage(winningResult.threeMatchesCount())
                + WinningMatchMessage.FOURTH.getMessage(winningResult.fourMatchesCount())
                + WinningMatchMessage.THIRD.getMessage(winningResult.fiveMatchesCount())
                + WinningMatchMessage.SECOND.getMessage(winningResult.fiveWithBonusCount())
                + WinningMatchMessage.FIRST.getMessage(winningResult.sixMatchesCount())
                + String.format(TOTAL_YIELD_MESSAGE, winningResult.totalYield());
    }
}
