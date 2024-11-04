package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class OutputView {
    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(formatLottoNumbers(lotto.getNumbers()));
        }
        System.out.println();
    }

    public static void printResults(Map<LottoRank, Integer> results, double yield) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        List<LottoRank> rankOrder = Arrays.asList(
                LottoRank.FIFTH,
                LottoRank.FOURTH,
                LottoRank.THIRD,
                LottoRank.SECOND,
                LottoRank.FIRST
        );

        for (LottoRank rank : rankOrder) {
            int count = results.getOrDefault(rank, 0);
            System.out.println(rank.getMessage() + " - " + count + "개");
        }
        System.out.println("총 수익률은 " + String.format("%.1f", yield) + "%입니다.");
    }

    private static String formatLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
