package lotto.view;

import lotto.model.Lotto;
import lotto.model.enums.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String ERROR_HEADER = "[ERROR]";
    private static final String PURCHASE_LOTTO_NUMBER = "개를 구매했습니다.";
    private static final String LOTTO_STATICS_HEADER = "당첨 통계\n---";
    private static final String TOTAL_PROFIT_RATE_IS = "총 수익률은 %.1f%%입니다.";
    private static final String PRINT_LOTTO_STAT = "%s (%,d원) - %d개%n";

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_HEADER + " " + errorMessage +"\n");
    }

    public static void printLotteryCount(int lotteryCount) {
        System.out.println(lotteryCount + PURCHASE_LOTTO_NUMBER);
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public static void printLottoStatistics(Map<Rank, Integer> lottoStats) {
        System.out.println(LOTTO_STATICS_HEADER);
        lottoStats.forEach((rank, count) -> {
            if (rank != Rank.NO_PRIZE) {
                System.out.printf(PRINT_LOTTO_STAT, rank.getDisplayName(), rank.getPrizeAmount(), count);
            }
        });
    }

    public static void printTotalProfitRate(double totalProfitRate) {
        System.out.printf(TOTAL_PROFIT_RATE_IS, totalProfitRate);
    }
}
