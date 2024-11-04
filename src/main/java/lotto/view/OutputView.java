package lotto.view;

import lotto.domain.LottoTicketGroup;
import lotto.domain.WinningStatistics;

public class OutputView {
    public static void printPurchasedTickets(LottoTicketGroup ticketGroup) {
        System.out.println(ticketGroup.getTickets().size() + "개를 구매했습니다.");
        ticketGroup.printAllTickets();
        System.out.println();
    }

    public static void printWinningStatistics(WinningStatistics statistics) {
        statistics.display();
    }

    public static void printProfit(double profit) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profit);
    }
}
