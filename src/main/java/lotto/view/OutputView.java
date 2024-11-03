package lotto.view;

import java.util.List;
import lotto.dto.WinningStatistics;

public class OutputView {
    private final static String WINNING_MESSAGE = "\n당첨통계\n---";
    private final static String TICKET_BUY_MESSAGE ="\n%d개를 구매했습니다.";
    public void printLottoTicketList(List<List<Integer>> tickets){
        System.out.println(String.format(TICKET_BUY_MESSAGE, tickets.size()));
        tickets.forEach(System.out::println);
    }

    public void printWinningStatistics(WinningStatistics winningStatistics){
        System.out.println(WINNING_MESSAGE);
        System.out.println(winningStatistics.toFinalString());
    }
}
