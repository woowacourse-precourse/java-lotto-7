package lotto;

import java.util.List;

public class PrintUtil {

    public static void printLotto(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(LottoResult result) {
        // 당첨 통계
        System.out.printf("3개 일치 (5,000원) - %d개%n", result.matchCount.get(MatchStatus.MATCH_3));
        System.out.printf("4개 일치 (50,000원) - %d개%n", result.matchCount.get(MatchStatus.MATCH_4));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", result.matchCount.get(MatchStatus.MATCH_5));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", result.matchCount.get(MatchStatus.MATCH_5_WITH_BONUS));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", result.matchCount.get(MatchStatus.MATCH_6));
        System.out.printf("총 수익률은 %.1f%%입니다.", result.revenueRatio);
    }
}
