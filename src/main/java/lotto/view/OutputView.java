package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.*;

public class OutputView {
    public void printLottoList(List<Lotto> lottoList) {
        System.out.printf("%d개를 구매했습니다.%n", lottoList.size());
        lottoList.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printResults(Map<Rank, Integer> results, double profit) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .forEach(rank -> System.out.printf("%d개 일치 (%,d원) - %d개%n",
                        rank.getMatchCount(), rank.getPrize(), results.getOrDefault(rank, 0)));
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profit);
    }
}
