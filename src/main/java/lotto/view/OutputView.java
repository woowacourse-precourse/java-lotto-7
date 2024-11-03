package lotto.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.RankCount;
import lotto.util.enums.Rank;

public class OutputView {
    private static final int LOTTO_PRICE = 1000;
    private static final String PREFIX = "[ERROR] ";

    public static void printPurchaseAmount(String purchaseAmount) {
        int amount = Integer.parseInt(purchaseAmount) / LOTTO_PRICE;
        System.out.println("\n" + amount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Integer> numbers) {
        String result = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result);
    }

    public static void printStatisticsHeader() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    public static void printResultStatistics(RankCount rankCount) {
        Rank rank = rankCount.getRank();
        int count = rankCount.getCount();

        System.out.printf("%d개 일치 (%d원) - %d개\n",
                rank.getMatchCount(), rank.getPrize(), count);
    }

    public static void printProfitRate(BigDecimal profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    public static void printErrorMessage(String messages) {
        System.out.println(PREFIX + messages);
    }


}
