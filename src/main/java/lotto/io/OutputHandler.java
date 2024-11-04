package lotto.io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constants.Rank;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.Result;

public class OutputHandler {
    private static final String PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---";
    private static final String TOTAL_PROFIT_RATE_MESSAGE = "\n총 수익률은 %,.1f%%입니다.%n";


    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + PURCHASE_COUNT_MESSAGE);

        for (Lotto lotto : lottos) {
            System.out.println(sortLotto(lotto));
        }
    }

    public static List<Integer> sortLotto(Lotto lotto) {
        List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public static void printResults(Result result, PurchaseAmount purchaseAmount) {
        System.out.println(WINNING_STATISTICS_MESSAGE);

        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                System.out.println(rank.getDescription() + " - " + result.getRankCount(rank) + "개");
            }
        }
        System.out.printf(TOTAL_PROFIT_RATE_MESSAGE, result.calculateProfitRate(purchaseAmount));
    }
}
