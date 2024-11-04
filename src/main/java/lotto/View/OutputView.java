package lotto.View;

import lotto.Common.Formatter;
import lotto.Common.Rank;
import lotto.Domain.Lotto;
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

        int[] prizeCount = checkPrizeCount(rank);

        String additionalString = "";
        int idx = 0;
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
                        prizeCount[idx++]);
            }
        }

        double profitRate = ((double) rank.getPrize() / (purchased*1000)) * 100.0;
        System.out.printf("총 수익률은 %s%%입니다.\n", Formatter.profitFormatted(profitRate));
    }

    private int[] checkPrizeCount(Rank rank) {
        int[] results = new int[5];
        switch (rank) {
            case SIX_MATCHES: results[4]++; break;
            case FIVE_MATCHES_WITH_BONUS: results[3]++; break;
            case FIVE_MATCHES: results[2]++; break;
            case FOUR_MATCHES: results[1]++; break;
            case THREE_MATCHES: results[0]++; break;
        }
        return results;
    }
}
