package lotto.view;

import java.util.Map;
import lotto.domain.Reward;
import lotto.domain.Tickets;
import lotto.domain.TotalResult;

public class OutputView {

    private static final String ENTER = "\n";
    private static final String LOTTERY_AMOUNT_TAIL_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_HEADER = "\n당첨 통계\n---";
    private static final String STATISTICS_FORMAT = "%d개 일치 (%,d원) - %d개\n";
    private static final String STATISTICS_SECOND_PLACE_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void printGeneratedTickets(Tickets tickets) {
        int ticketAmount = tickets.getTicketAmount();
        System.out.println(ENTER + ticketAmount + LOTTERY_AMOUNT_TAIL_MESSAGE);
        tickets.getUnmodifiableTickets().forEach(ticket -> System.out.println(ticket.getUnmodifiableNumbers()));
    }

    public void printResult(TotalResult totalResult) {
        System.out.println(RESULT_HEADER);
        Map<Reward, Integer> result = totalResult.getUnmodifiableTotalResult();
        result.forEach(this::printEachStatistic);
    }

    private void printEachStatistic(Reward reward, int amount) {
        int hitCount = reward.getHitCount();
        long prizeAmount = reward.getPrizeAmount();

        if (reward.isSecondPlace()) {
            System.out.printf(STATISTICS_SECOND_PLACE_FORMAT, hitCount, prizeAmount, amount);
            return;
        }
        System.out.printf(STATISTICS_FORMAT, hitCount, prizeAmount, amount);
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_FORMAT, rateOfReturn);
    }
}
