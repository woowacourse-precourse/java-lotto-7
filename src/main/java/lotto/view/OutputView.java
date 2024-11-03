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
        System.out.println("\n"+ amount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Integer> numbers) {
        String result = numbers.stream()
                .sorted()
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

        String result = rank.getDescription() + " - " + count + "개";
        System.out.println(result);
    }

    public static void printProfitRate(BigDecimal profitRate) {
        String result = "총 수익률은 " + profitRate.setScale(1, BigDecimal.ROUND_HALF_UP) + "%입니다.";
        System.out.println(result);
    }

    public static void printErrorMessage(String messages) {
        System.out.println(PREFIX + messages);
    }
}
