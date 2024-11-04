package lotto.view;

import lotto.run.Lotto;
import lotto.run.Prize;

import java.util.List;
import java.util.Map;

public class Output {

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public static void printLottoState(Map<Prize, Integer> lottoStats) {
        System.out.println("\n당첨 통계\n---");
        lottoStats.forEach((prize, count) -> {
            if (prize != Prize.NO_PRIZE) {
                System.out.printf("%s (%,d원)- %d개%n", prize.getDisplayName(), prize.getPrizeNum(), count);
            }
        });
    }

    public static void printTotalPrizeRate(double totalPrizeRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", totalPrizeRate);
    }
    
}
