package lotto;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String PURCHASE_NUMBER = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS = "\n당첨 통계\n---";
    private static final String EARNING_RATE = "총 수익률은 %.1f%%입니다.";

    public void printLottos(List<Lotto> lottos) {
        System.out.printf(PURCHASE_NUMBER, lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public void printWinningStatistics(Map<Rank, Integer> winnings, double earningRate) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(Rank.getRankInfo(Rank.FIFTH) + " - " + winnings.getOrDefault(Rank.FIFTH, 0) + "개");
        System.out.println(Rank.getRankInfo(Rank.FOURTH) + " - " + winnings.getOrDefault(Rank.FOURTH, 0) + "개");
        System.out.println(Rank.getRankInfo(Rank.THIRD) + " - " + winnings.getOrDefault(Rank.THIRD, 0) + "개");
        System.out.println(Rank.getRankInfo(Rank.SECOND) + " - " + winnings.getOrDefault(Rank.SECOND, 0) + "개");
        System.out.println(Rank.getRankInfo(Rank.FIRST) + " - " + winnings.getOrDefault(Rank.FIRST, 0) + "개");
        System.out.printf(EARNING_RATE, earningRate);
    }
}
