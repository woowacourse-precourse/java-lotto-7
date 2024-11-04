package lotto.View;

import Common.Formatter;
import Common.Rank;
import lotto.Lotto;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    public void printPurchasedLotto(List<Lotto> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (Lotto lotto : tickets) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printWinningStat(Rank rank, int purchased) {
        System.out.println("당첨 통계");
        System.out.println("---");
        String additionalString = "";
        for (Rank r : Rank.values()) {
            if (r != Rank.NONE) {
                if (r == Rank.FIVE_MATCHES_WITH_BONUS) {
                    additionalString = ", 보너스 볼 일치";
                } else {
                    additionalString = "";
                }
                System.out.printf("%d개 일치%s (%s원) - %d개\n",
                        r.getMatchCount(),
                        additionalString,
                        Formatter.currencyFormatted(r.getPrize()),
                        r.getPrizeCount());
            }
        }

        double profitRate = ((double) rank.getPrize() / (purchased*1000)) * 100.0;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
