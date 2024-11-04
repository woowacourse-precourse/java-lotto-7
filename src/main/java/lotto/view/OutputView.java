package lotto.view;

import lotto.model.Lotto;
import lotto.model.enums.Rank;

import java.util.List;
import java.util.Map;

import static lotto.model.constants.OutputViewConstants.*;

public class OutputView {

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_HEADER + " " + errorMessage +"\n");
    }

    public static void printLotteryCount(int lotteryCount) {
        System.out.println(lotteryCount + PURCHASE_LOTTO_NUMBER.getMessage());
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
                System.out.printf(PRINT_LOTTO_STAT.getMessage(), rank.getDisplayName(), rank.getPrizeAmount(), count);
            }
        });
    }

    public static void printTotalProfitRate(double totalProfitRate) {
        System.out.printf(TOTAL_PROFIT_RATE_IS.getMessage(), totalProfitRate);
    }
}
