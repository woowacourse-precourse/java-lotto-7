package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lotto.domain.LotteryMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoResultChecker;
import lotto.domain.Rank;

public class OutputView {

    public static void printPurchaseLotto(LotteryMachine lotteryMachine) {
        System.out.printf("\n%d개를 구매했습니다.\n", lotteryMachine.getLottoQuantity());
        List<Lotto> purchaseLotto = lotteryMachine.getPurchaseLotto();
        for (Lotto lotto : purchaseLotto) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
        System.out.println();
    }

    public static void printLottoResult(LottoResultChecker lottoResultChecker) {
        System.out.println("\n당첨 통계\n" + "---");

        Map<Rank, Integer> rankCount = lottoResultChecker.getRankCount();
        List<Rank> reverseRank = Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .toList();
        for (Rank rank : reverseRank) {
            Integer matchCount = rankCount.get(rank);
            if (rank.equals(Rank.NONE)) {
                continue;
            }
            if (rankCount.get(rank) == null) {
                matchCount = 0;
            }
            System.out.printf("%s - %d개\n", rank.getMessage(), matchCount);
        }
    }

    public static void printLottoProfit(double profit) {
        String profitFormat = String.format("%.1f", profit);
        System.out.printf("총 수익률은 %s%%입니다.", profitFormat);
    }

}
