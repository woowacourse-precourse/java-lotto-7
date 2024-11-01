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
    public static void displayRankCounts(Map<LottoRank, Integer> rankCounts) {
        for (LottoRank rank : LottoRank.values()) {
            int count = rankCounts.getOrDefault(rank, 0);
            System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getPrize() + "원) - " + count + "개");
        }
    }
}
