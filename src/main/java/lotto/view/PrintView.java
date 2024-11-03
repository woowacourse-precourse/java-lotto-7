package lotto.view;

import java.util.List;
import lotto.LottoPrize;

public class PrintView {
    public void printLotties(List<List<Integer>> lotties) {
        System.out.println(lotties.size()+"개를 구매했습니다.");
        for (List<Integer> lotto : lotties) {
            System.out.println(lotto.toString());
        }
    }

    public void printStatistic(String earnRate, List<Integer> winLottiesNumber) {
        System.out.println("당첨 통계");
        System.out.println("---");
        int index = 0;
        for (LottoPrize prize : LottoPrize.values()) {
            System.out.println(prize.getCondition() + " (" + prize.getStringPrize() + "원) - " + winLottiesNumber.get(index)+"개");
            index++;
        }
        System.out.println("총 수익률은 "+earnRate+"%입니다.");
    }
}
