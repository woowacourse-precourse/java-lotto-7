package lotto.view;

import java.util.Map;
import lotto.model.LottoTicket;
import lotto.model.Rank;

public class OutputView {

    public static void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottoTicket(LottoTicket ticket) {
        System.out.println(ticket);
    }

    public static void printRankCounts(Map<Rank, Long> ranks) {
        System.out.println("당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.MISS) {
                System.out.println(rank.getDescription() + " - " + ranks.getOrDefault(rank, 0L) + "개");
            }
        }
    }

    public static void printRateOfReturn(long buy, long prize) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", (prize / (double) buy * 100));
    }
}
