package lotto;


import java.util.List;
import java.util.Map;

public class OutputManager {

    public static void printLottoCount(int count) {
        System.out.printf((InputMessage.LOTTO_COUNT.getInputMessage()) + "%n", count);
    }

    public static void printLottoTickets(List<List<Integer>> lottoTickets) {
        for (List<Integer> ticket : lottoTickets) {
            System.out.println(ticket);
        }
    }

    public static void printWinningStatistics(Map<MatchCountMessage, Integer> winningStatistics) {
        System.out.println(OutputMessage.WINNING_STATISTICS.getMessage());

        for (MatchCountMessage match : MatchCountMessage.values()) {
            int count = winningStatistics.getOrDefault(match, 0);
            System.out.println(match.getMessage() + count + "개");
        }
    }


}
