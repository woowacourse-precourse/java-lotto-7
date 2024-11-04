package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.Ranks;
import lotto.model.Tickets;

public class Output {
    public static void printTickets(Tickets tickets) {
        List<Lotto> lottoTickets = tickets.getTickets();
        int ticketAmount = tickets.getTicketAmount();

        System.out.println();
        System.out.println(ticketAmount + "개를 구매했습니다.");
        for (Lotto ticket : lottoTickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public static void printProfits(Prize prize) {
        printProfitResult();
        printProfitRate(prize);
    }

    private static void printProfitResult() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Ranks rank : Ranks.values()) {
            String rankMessage = rank.getMessage();
            int rankCount = rank.getCount();

            if (rank == Ranks.MISS) {
                continue;
            }
            System.out.println(rankMessage + rankCount + "개");
        }
    }

    private static void printProfitRate(Prize prize) {
        double profitRate = prize.getProfitRate();
        String profitRateRound = String.format("%,.1f", profitRate);

        System.out.println("총 수익률은 " + profitRateRound + "%입니다.");
    }
}