package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;

public class Outputview {
    public static void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.printf("%d개를 구매했습니다.%n", lottoTickets.size());
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResults(List<Rank> results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        int[] rankCounts = new int[Rank.values().length];

        for (Rank rank : results) {
            rankCounts[rank.ordinal()]++;
        }

        // Rank.values()를 List로 변환한 뒤 역순으로 정렬
        List<Rank> ranks = Arrays.asList(Rank.values());
        Collections.reverse(ranks);

        // 역순으로 정렬된 ranks 리스트 사용
        for (Rank rank : ranks) {
            if (rank == Rank.NONE) {
                continue;
            }
            String bonusInfo = rank == Rank.SECOND ? ", 보너스 볼 일치" : "";
            String prizeFormatted = String.format("%,d", rank.getPrize()); // 천 단위 쉼표 추가
            System.out.printf("%d개 일치%s (%s원) - %d개%n",
                    rank.getMatchCount(), bonusInfo, prizeFormatted, rankCounts[rank.ordinal()]);
        }
    }

    public static void printYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }
}
