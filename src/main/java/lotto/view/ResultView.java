package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Prize;

import java.util.List;

public class ResultView {
    public static void displayRequestPurchaseAmount() {
        System.out.println(ConsoleMessage.REQ_PURCHASE_AMOUNT);
    }

    public static void displayRequestWinningNumbers() {
        System.out.println(ConsoleMessage.REQ_WINNING_NUMBERS);
    }

    public static void displayRequestBonusNumber() {
        System.out.println(ConsoleMessage.REQ_BONUS_NUMBERS);
    }

    public static void displayPurchasedLottoCount(int lottoCount) {
        System.out.printf(ConsoleMessage.ACK_LOTTO_COUNT, lottoCount);
    }

    public static void displayMyLottos(List<Lotto> myLottos) {
        myLottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void displayStatistics(List<Prize> results) {
        System.out.println(ConsoleMessage.LOTTO_STATISTICS_HEADER);
        for (Prize rank : Prize.values()) {
            long count = results.stream().filter(result -> result == rank).count();

            if (rank == Prize.FIVE_MATCH_WITH_BONUS) {
                System.out.printf((ConsoleMessage.MATCH_COUNT_AND_PRIZE) + "%n", rank.getMatchCount(), ", 보너스 볼 일치", rank.getPrize(), count);
                continue;
            }
            if (rank != Prize.NO_MATCH) {
                System.out.printf((ConsoleMessage.MATCH_COUNT_AND_PRIZE) + "%n", rank.getMatchCount(), "", rank.getPrize(), count);
            }
        }
    }

    public static void displayProfitRate(double profitRate) {
        System.out.printf(ConsoleMessage.MATCH_COUNT_AND_PRIZE_BONUS, profitRate);
    }
}
