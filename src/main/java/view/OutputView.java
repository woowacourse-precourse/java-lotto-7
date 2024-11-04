package view;

import model.Lotto;
import model.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    private final static String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private final static String WINNING_STATISTICS = "당첨 통계\n---";

    public void publishLotto(int count, List<Lotto> lottoList){
        System.out.println(count + PURCHASE_MESSAGE);
        lottoList.forEach(lotto -> System.out.println(lotto.toString()));
        System.out.println();
    }

    public void printStatistics(Map<Rank, Integer> rankCount) {
        System.out.println(WINNING_STATISTICS);
        for (Rank rank : Rank.values()) {
            if (rank != Rank.MISS) {
                System.out.println(rank.message + rankCount.get(rank) + "개");
            }
        }
    }

    public void printTotalReturn(double rate){
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rate);
    }
}
