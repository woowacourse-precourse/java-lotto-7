package lotto;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class OutputView {

    public static void displayPurchasedTickets(List<Lotto> tickets) {
        System.out.println("\n" + tickets.size() + "개를 구매했습니다.");

        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }

    }

    public static void displayResults(int[] results, double profitRate) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        LottoRank[] ranks = LottoRank.values();

        for (int i = 0; i < results.length; i++) {
            LottoRank rank = ranks[i];
            if (rank != LottoRank.MISS) {
                String formattedPrize = NumberFormat.getInstance(Locale.KOREA).format(rank.getPrize());
                System.out.println(rank.getMatchCount() + "개 일치" +
                        (rank.isMatchBonus() ? ", 보너스 볼 일치" : "") +
                        " (" + formattedPrize + "원) - " + results[i] +
                        "개");
            }
        }

        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
