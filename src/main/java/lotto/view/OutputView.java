package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Prize;

public class OutputView {
    public static void printPurchaseCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> {
            String numbers = lotto.getNumbers().stream()
                    .map(n -> String.valueOf(n.value()))
                    .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(numbers);
        });
    }

    public static void printResults(Map<Prize, Integer> results, int amount) {
        System.out.println("당첨 통계");
        System.out.println("---");

        DecimalFormat formatter = new DecimalFormat("#,###");

        for (Prize prize : Prize.values()) {
            if (prize != Prize.NONE) {
                System.out.printf("%s (%s원) - %d개%n",
                        prize.getDescription(),
                        formatter.format(prize.getPrizeMoney()),
                        results.get(prize));
            }
        }

        printReturnRate(results, amount);
    }

    private static void printReturnRate(Map<Prize, Integer> results, int amount) {
        double totalPrize = results.entrySet().stream()
                .mapToDouble(e -> e.getKey().getPrizeMoney() * e.getValue())
                .sum();
        double returnRate = (totalPrize / amount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", returnRate);
    }
}
