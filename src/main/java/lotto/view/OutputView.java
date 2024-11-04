package lotto.view;

import lotto.model.Lottos;
import lotto.enumerate.Rank;

import java.util.List;
import java.util.Map;

import static lotto.enumerate.Rank.*;

public class OutputView {
    public void printRank(Map<Rank, Integer> ranks) {
        List<Rank> winRanks = List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (Rank rank : winRanks) {
            System.out.print(rank.getRankPrintSentence());
            System.out.print(" - ");
            System.out.printf("%d개",ranks.getOrDefault(rank,0));
            System.out.println();
            ranks.get(rank);
        }
    }

    public void printEarningRate(double calculate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", calculate);
    }

    public void printBuyLottoCount(int count) {
        System.out.printf("\n%d개를 구매했습니다.",count);
    }
    public void printLottoNumbers(Lottos lottos){
        System.out.println();
        lottos.getLottos().forEach(System.out::println);
    }
}
