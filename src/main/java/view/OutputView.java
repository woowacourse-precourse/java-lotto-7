package view;

import model.Lotto;
import model.LottoResult;
import util.Message;

import java.util.List;

public class OutputView {

    public void printTicketCount(int ticketCount) {
        System.out.println(ticketCount + Message.TICKET_COUNT);
    }

    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printResults(List<LottoResult> results) {
        System.out.println(Message.WIN_STATISTICS_HEADER);
        System.out.printf(Message.MATCH_3 + "\n", countResults(results, LottoResult.FIFTH));
        System.out.printf(Message.MATCH_4 + "\n", countResults(results, LottoResult.FOURTH));
        System.out.printf(Message.MATCH_5 + "\n", countResults(results, LottoResult.THIRD));
        System.out.printf(Message.MATCH_5_WITH_BONUS + "\n", countResults(results, LottoResult.SECOND));
        System.out.printf(Message.MATCH_6 + "\n", countResults(results, LottoResult.FIRST));
    }

    public void printProfitRate(double rate) {
        System.out.printf(Message.PROFIT_RATE, rate);
    }

    private long countResults(List<LottoResult> results, LottoResult resultType) {
        return results.stream().filter(result -> result == resultType).count();
    }

    public void printError(String message) {
        System.out.println(Message.ERROR_PREFIX + message);
    }
}
