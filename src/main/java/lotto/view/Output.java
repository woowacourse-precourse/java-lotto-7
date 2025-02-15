package lotto.view;

import lotto.model.Lotto;
import lotto.status.LottoPrize;

import java.util.List;

public class Output {
    int[] ticketRank;
    double profitRate;

    public Output(int[] ticketRank, double profitRate) {
        this.ticketRank = ticketRank;
        this.profitRate = profitRate;

        printStatistics();
        printProfitRate();
    }


    public static void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.println("\n" + lottoTickets.size() + "개를 구매했습니다.");
        lottoTickets.stream()
                    .map(lotto -> lotto.getNumbers()
                                       .toString())
                    .forEach(System.out::println);
    }

    private void printStatistics() {
        StringBuilder result = new StringBuilder("\n당첨 통계\n---");
        final LottoPrize[] prize = LottoPrize.values();

        for (int i = ticketRank.length - 1; i >= 0; i--) {
            result.append(String.format("\n%s (%,d원) - %d개",
                    prize[i].getTitle(), prize[i].getMoney(), ticketRank[i]));
        }

        System.out.println(result);
    }

    private void printProfitRate() {
        StringBuilder result = new StringBuilder();
        result.append("총 수익률은 ")
              .append(profitRate)
              .append("%입니다.");

        System.out.println(result);
    }

}