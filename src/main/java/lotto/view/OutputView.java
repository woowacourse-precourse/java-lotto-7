package lotto.view;

import java.util.List;
import lotto.dto.WinningResult;
import lotto.message.WinningMatchMessage;

public class OutputView {

    private static final String PURCHASED_QUANTITY_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_RESULT_TITLE_MESSAGE = "당첨 통계%n---%n%s";
    private static final String COUNT_MESSAGE = " - %d개%n";
    private static final String TOTAL_YIELD_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printPurchasedQuantity(int purchasedQuantity) {
        String message = String.format(PURCHASED_QUANTITY_MESSAGE, purchasedQuantity);
        System.out.println(message);
    }

    public void printLottoTickets(List<List<Integer>> lottoTickets) {
        StringBuilder message = new StringBuilder();
        for (List<Integer> lottoTicket : lottoTickets) {
            message.append(lottoTicket.toString())
                    .append(System.lineSeparator());
        }
        System.out.println(message);
    }

    public void printWinningResult(WinningResult winningResult) {
        String message = String.format(WINNING_RESULT_TITLE_MESSAGE, buildWinningStatistics(winningResult));
        System.out.println(message);
    }

    private String buildWinningStatistics(WinningResult winningResult) {
        return WinningMatchMessage.FIFTH.get()
                + getResultCount(winningResult.threeMatchesCount())
                + WinningMatchMessage.FOURTH.get()
                + getResultCount(winningResult.fourMatchesCount())
                + WinningMatchMessage.THIRD.get()
                + getResultCount(winningResult.fiveMatchesCount())
                + WinningMatchMessage.SECOND.get()
                + getResultCount(winningResult.fiveWithBonusCount())
                + WinningMatchMessage.FIRST.get()
                + getResultCount(winningResult.sixMatchesCount())
                + getTotalYield(winningResult);
    }

    private String getResultCount(int count) {
        return String.format(COUNT_MESSAGE, count);
    }

    private String getTotalYield(WinningResult winningResult) {
        return String.format(TOTAL_YIELD_MESSAGE, winningResult.totalYield());
    }
}
