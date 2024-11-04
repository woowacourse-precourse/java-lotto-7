package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
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
        lottoNumbers.forEach(System.out::println);
    }

    private static String formatNumber(long number) {
        return String.format("%,d", number);
    }

    public static void printStatistics(Map<Rank, Integer> rankCount, double roi) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.FAIL)
                .sorted(Comparator.comparingInt(Rank::getPrize))
                .forEach(rank -> System.out.printf("%s (%s원) - %d개%n",
                        rank.getLabel(),
                        formatNumber(rank.getPrize()),
                        rankCount.getOrDefault(rank, 0)));

        System.out.printf("총 수익률은 %.1f%%입니다.%n", roi);
    }

    public static void printError(Exception e) {
        System.out.println("[ERROR] 예기치 않은 오류가 발생했습니다: " + e.getMessage());
    }
}
