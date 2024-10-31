package lotto.view;

import java.util.List;
import lotto.dto.WinningResult;

public class OutputView {

    private static final String PURCHASED_QUANTITY_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_RESULT_MESSAGE = "\n당첨 통계\n---\n%s";

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
        return String.format("3개 일치 (5,000원) - %d개%n", winningResult.threeMatchesCount())
                + String.format("4개 일치 (50,000원) - %d개%n", winningResult.fourMatchesCount())
                + String.format("5개 일치 (1,500,000원) - %d개%n", winningResult.fiveMatchesCount())
                + String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", winningResult.fiveWithBonusCount())
                + String.format("6개 일치 (2,000,000,000원) - %d개%n", winningResult.sixMatchesCount())
                + String.format("총 수익률은 %.1f%%입니다.%n", winningResult.totalYield());
    }
}
