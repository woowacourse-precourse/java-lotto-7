package lotto.ui;

import java.util.List;
import java.util.Map;
import lotto.domain.Prize;

public class outputView {
    public static void showPurchasedNumbers(List<String> lottery){
        System.out.println(lottery.size() + "개를 구매했습니다.");

        for(String numbers : lottery){
            System.out.println("[" + numbers + "]");
        }
    }

    public static void summaryWinning(Map<Prize, Integer> winnings, double ratio){
        System.out.println("당첨 통계");
        System.out.println("---");

        for(Prize prize : winnings.keySet()){
            System.out.println(prize.toString() + "-" + winnings.get(prize) + "개");
        }

        System.out.printf("총 수익률은 %.1f 입니다", ratio);
    }
}
