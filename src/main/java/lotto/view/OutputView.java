package lotto.view;

import lotto.model.WinningRank;

import java.util.List;

public class OutputView {

    public static void printLottoNumbers(List<List<Integer>> lottoNumbers) {
        System.out.println();
        System.out.println(lottoNumbers.size() + "개를 구매했습니다.");
        lottoNumbers.forEach(System.out::println);
    }

    public static void printStatistics(List<WinningRank> results) {
        System.out.println();
        System.out.println("당첨 통계\n---");

        for (WinningRank rank : WinningRank.values()) {
            if (rank != WinningRank.NO_MATCH) {
                long count = results.stream().filter(result -> result == rank).count();
                System.out.printf("%s (%,d원) - %d개%n",
                        rank.getDescription(), rank.getPrize(), count);
            }
        }
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %,.1f%%입니다.%n", profitRate);
    }
}
