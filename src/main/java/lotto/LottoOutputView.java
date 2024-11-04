package lotto;

import java.util.*;

public class LottoOutputView {

    private static void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }
    public static void printPurchasedLottoCount(List<Lotto> lottos) {
        printLottoCount(lottos.size());
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            printSortedNumber(numbers);
        }
    }

    private static void printSortedNumber(List<Integer> numbers) {
        Collections.sort(numbers);
        System.out.println(numbers);
    }

    private static void printRankResults(Map<LottoRank, Integer> result, List<LottoRank> sortedRanks) {
        for (LottoRank rank : sortedRanks) {
            int count = result.getOrDefault(rank, 0);
            String formattedPrize = String.format("%,d", rank.getPrize());
            System.out.printf("%s (%s원) - %d개%n", rank.getRank(), formattedPrize, count);
        }
    }

    private static List<LottoRank> sortedRanks() {
        List<LottoRank> sortedRanks = Arrays.asList(LottoRank.values());
        sortedRanks.sort(Comparator.comparingInt(LottoRank::getMatchCount));
        return sortedRanks;
    }

    public static void printResult(Map<LottoRank, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");

        List<LottoRank> sortedRanks = sortedRanks();

        printRankResults(result, sortedRanks);
    }

    public static void printrateOfReturn(double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rate);
    }
}
