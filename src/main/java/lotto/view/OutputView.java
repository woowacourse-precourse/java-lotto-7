package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printPurchasedLottos(final List<Lotto> purchasedLottos) {
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLottos) {
            List<Integer> sortedLotto = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedLotto);
            System.out.println(sortedLotto);
        }
    }

    public static void printLottoResult(final Map<Rank, Integer> resultCountMap) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = Rank.values().length - 1; i >= 0; i--) {
            Rank rank = Rank.values()[i];
            int count = resultCountMap.get(rank);

            String bonusNumberText = "";
            if (rank.getNeedToCheckBonus()) bonusNumberText = ", 보너스 볼 일치";
            System.out.printf("%d개 일치%s (%,d원) - %d개%n", rank.getMatchCount(), bonusNumberText, rank.getPrize(), count);
        }
    }

    public static void printRateOfReturn(final double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    public static void printErrorMessage(final String message) {
        System.out.println(message);
    }
}
