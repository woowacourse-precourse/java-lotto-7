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
        for (LottoRank rank : LottoRank.values()) {
            int count = rankCounts.getOrDefault(rank, 0);
            System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getPrize() + "원) - " + count + "개");
        }
        System.out.println("총 수익률은 " + profitRate + "% 입니다.");
    }
}
