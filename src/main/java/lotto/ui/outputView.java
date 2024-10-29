package lotto.ui;

import java.util.List;

public class outputView {
    public static void showPurchasedNumbers(List<String> lottery){
        System.out.println(lottery.size() + "개를 구매했습니다.");

        for(String numbers : lottery){
            System.out.println("[" + numbers + "]");
        }
    }

    public static void summaryWinning(List<Integer> winnings){
        System.out.println("당첨 통계");
        System.out.println("---");

        for(int i = 3; i<winnings.size(); i++){
            System.out.println();
        }

        System.out.println("총 수익률은 ?? 입니다" );
    }
}
