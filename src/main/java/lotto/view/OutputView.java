package lotto.view;

import java.util.List;
import lotto.dto.WinningResult;
import lotto.util.message.WinningMatchMessage;

public class OutputView {

    private static final String PURCHASED_QUANTITY_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_RESULT_TITLE_MESSAGE = "\n당첨 통계\n---\n%s";
    private static final String TOTAL_YIELD_MESSAGE = "총 수익률은 %.1f%%입니다.%n";
    private static final String COUNT_MESSAGE = " - %d개\n";

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
        System.out.printf(WINNING_RESULT_TITLE_MESSAGE, buildWinningStatistics(winningResult));
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
                + String.format(TOTAL_YIELD_MESSAGE, winningResult.totalYield());
    }

    private String getResultCount(int count) {
        return String.format(COUNT_MESSAGE, count);
    }
}
