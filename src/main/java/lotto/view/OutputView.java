package lotto.view;

import static lotto.Application.lottos;
import static lotto.Application.rankCounter;

import lotto.model.Lotto;
import lotto.model.Rank;
import static lotto.controller.LogicControl.calculateBenfit;

public class OutputView {
    public static void outputLottoNumbers() {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.printNumbers());
        }
    }

    public static void printLottoOutput() {
        System.out.println("당첨 통계");
        System.out.println("---");
        rankCounter.forEach((rank, count) -> {
            if (rank != Rank.MISS)
                Rank.printRankPrize(rank, count);
        });
        double benefit = Math.round(calculateBenfit() / (1000 * lottos.size()) * 100 * 10);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", benefit / 10);
    }
}
