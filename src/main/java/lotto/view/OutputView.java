package lotto.view;

import lotto.constant.Rank;
import lotto.dto.GeneratedTickets;
import lotto.dto.LottoResults;

public class OutputView {

    public static final String PURCHASED_TICKET_MESSAGE = "\n%d개를 구매했습니다.\n";
    public static final String WINNING_RESULT_MESSAGE = "\n당첨 통계\n---";
    public static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";
    public static final String NUMBER_OF_MATCHED_MESSAGE = " - %d개\n";

    public void printGeneratedTickets(GeneratedTickets generatedTicket) {
        System.out.printf((PURCHASED_TICKET_MESSAGE), generatedTicket.getTicketCount());
        generatedTicket.getTickets().forEach(System.out::println);
    }

    public void printRank(LottoResults results) {
        System.out.println(WINNING_RESULT_MESSAGE);
        printRankResult(results);
        printStatistics(results);
    }

    private void printRankResult(LottoResults results) {
        Rank[] ranksInOrder = {Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST};
        for (Rank rank : ranksInOrder) {
            System.out.print(rank);
            System.out.printf(NUMBER_OF_MATCHED_MESSAGE, results.getNumberOfMatched(rank));
        }
    }

    private void printStatistics(LottoResults results) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, results.getPercentageOfMatched());
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
