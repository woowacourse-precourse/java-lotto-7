package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "개를 구매했습니다.";

    public static void printPurchaseAmountMessage(int count){
        System.out.println("\n"+count+PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printUserLotto(List<Lotto> lottoNumbers) {
        for (Lotto lotto : lottoNumbers) {
            System.out.println(lotto);
        }
    }

    public static void printStatistics(Map<Rank, Integer> rankCount, long totalWinnings, double roi) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        Arrays.stream(Rank.values())
                .filter(rank -> rankCount.getOrDefault(rank, 0) > 0)
                .forEach(rank -> System.out.printf("%s (%d원) - %d개%n", rank.getLabel(), rank.getPrize(), rankCount.get(rank)));

        System.out.printf("총 수익률은 %.1f%%입니다.%n", roi);
    }
}
