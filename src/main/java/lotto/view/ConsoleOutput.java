package lotto.view;

import lotto.Lotto;
import lotto.Rank;
import lotto.WinningResult;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 8개를 구매했습니다.
 * [8, 21, 23, 41, 42, 43]
 * [3, 5, 11, 16, 32, 38]
 * [7, 11, 16, 35, 36, 44]
 * [1, 8, 11, 31, 41, 42]
 * [13, 14, 16, 38, 42, 45]
 * [7, 11, 30, 40, 42, 43]
 * [2, 13, 22, 32, 38, 45]
 * [1, 3, 5, 14, 22, 45]
 * <p>
 * 당첨 통계
 * ---
 * 3개 일치 (5,000원) - 1개
 * 4개 일치 (50,000원) - 0개
 * 5개 일치 (1,500,000원) - 0개
 * 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
 * 6개 일치 (2,000,000,000원) - 0개
 * 총 수익률은 62.5%입니다.
 */
public class ConsoleOutput {
    public void printLottoTicket(int lottoQuantity, List<Lotto> lottos) {
        System.out.println("\n" + lottoQuantity + "개를 구매했습니다.");
        lottos.forEach(
                lotto -> System.out.println(lotto.getNumbers())
        );
    }

    // TODO: 제대로 보기
    public void printPrizeStatistics(WinningResult result) {
        System.out.println("당첨통계");
        System.out.println("---");
        Map<Rank, Integer> counts = result.getCounts();
        Set<Map.Entry<Rank, Integer>> entries = counts.entrySet();
        for (Map.Entry<Rank, Integer> entry : entries) {
            Rank rank = entry.getKey();
            if (rank.isMatchBonus()) {
                System.out.println(rank.getMatchCount() + "개 일치, 보너스 볼 일치 (" + rank.getFormattedPrize() + "원) - " + entry.getValue() + "개");
            } else if (rank == Rank.NONE) {
                System.out.println();
            } else {
                System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getFormattedPrize() + "원) - " + entry.getValue() + "개");
            }
        }
        System.out.println("총 수익률은 " + result.calculatePrizeRate() + "%입니다.");
    }
}
