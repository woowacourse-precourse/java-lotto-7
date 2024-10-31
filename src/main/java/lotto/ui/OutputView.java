package lotto.ui;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Prize;

public class OutputView {
    public static void showPurchasedNumbers(List<Lotto> lottos){
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for(Lotto lotto : lottos){
            System.out.println(lotto.toString());
        }
    }

    public static void summaryWinning(Map<Prize, Integer> winnings, double ratio){
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for(Prize prize: Prize.lowToHigh()){
            System.out.println(prize.toString() + winnings.getOrDefault(prize, 0) + "개");
        }

        System.out.printf("총 수익률은 %.1f%%입니다.", ratio);
    }
}
