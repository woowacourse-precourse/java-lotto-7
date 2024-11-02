package lotto.view;

import java.util.List;
import lotto.dto.GeneratedTickets;
import lotto.dto.LottoResult;

public class OutputView {

    public static final String PURCHASED_TICKET_MESSAGE = "%d개를 구매했습니다.";
    public static final String WINNING_RESULT_MESSAGE = "당첨 통계\n---";

    public void printGeneratedTickets(GeneratedTickets generatedTicket) {
        System.out.println(String.format(PURCHASED_TICKET_MESSAGE, generatedTicket.ticketCount()));
        generatedTicket.getTickets().forEach(System.out::println);
    }

    public void printResult(List<LottoResult> results) {
        System.out.println(WINNING_RESULT_MESSAGE);
        for (LottoResult result : results) {
            System.out.print(result.getRank().toString());
            System.out.printf(" - %d개%n", result.getNumberOfMatched());
        }
    }
}
