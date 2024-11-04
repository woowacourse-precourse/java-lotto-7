package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintResult {
    public static void printPurchasedLottos(List<Lotto> purchasedLottos) {
        System.out.println("\n" + purchasedLottos.size() + "개를 구매했습니다.");
        for (Lotto purchasedLotto : purchasedLottos) {
            List<Integer> numbers = purchasedLotto.getNumbers();
            List<Integer> sortedNumbers = new ArrayList<>(numbers);
            Collections.sort(sortedNumbers);
            System.out.println(sortedNumbers);
        }
    }

    public static void printLottoResultStatistics(LottoResultChecker lottoResultChecker, int lottoPurchaseAmount) {
        System.out.println("\n당첨 통계\n---");
        for (Prize prize : Prize.values()) {
            int count = lottoResultChecker.getPrizeCountMap().getOrDefault(prize, 0);
            System.out.printf("%s (%s원) - %d개\n", prize.getDescription(), String.format("%,d", prize.getPrizeAmount()), count);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", lottoResultChecker.calculateYield(lottoPurchaseAmount));
    }
}
