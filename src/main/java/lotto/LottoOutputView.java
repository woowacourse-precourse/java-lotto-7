package lotto;

import java.util.*;

public class LottoOutputView {
    public static void printPurchasedLottoCount(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    public static void printResult(Map<LottoRank, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");

        List<LottoRank> sortedRanks = Arrays.asList(LottoRank.values());
        sortedRanks.sort(Comparator.comparingInt(LottoRank::getMatchCount));

        for (LottoRank rank : sortedRanks) {
            int count = result.getOrDefault(rank, 0);
            String formattedPrize = String.format("%,d", rank.getPrize());
            System.out.printf("%s (%s원) - %d개%n", rank.getRank(), formattedPrize, count);
        }
    }

    public static void printrateOfReturn(double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rate);
    }
}
