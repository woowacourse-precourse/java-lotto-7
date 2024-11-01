package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoRank;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printLottoNumbers(int count, List<List<Integer>> lottoNumbers) {
        System.out.println(count + "개를 구매했습니다.");
        for (List<Integer> numbers : lottoNumbers) {
            System.out.println(numbers);
        }
    }

    public static void printWinningStatistics(Map<LottoRank, Integer> rankCounts, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("--");

        LottoRank[] ranks = {
                LottoRank.FIFTH,
                LottoRank.FOURTH,
                LottoRank.THIRD,
                LottoRank.SECOND,
                LottoRank.FIRST
        };

        for (LottoRank rank : ranks) {
            printRankCount(rank, rankCounts);
        }
        System.out.println("총 수익률은 " + profitRate + "% 입니다.");
    }

    private static void printRankCount(LottoRank rank, Map<LottoRank, Integer> rankCounts) {
        int count = rankCounts.getOrDefault(rank, 0);
        if (rank == LottoRank.SECOND) {
            System.out.println("5개 일치, 보너스 볼 일치 (" + rank.getPrize() + "원) - " + count + "개");
            return;
        }
        System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getPrize() + "원) - " + count + "개");
    }
}
