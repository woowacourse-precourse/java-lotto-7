package lotto.view;

import java.util.List;
import lotto.model.Result;

public class OutputView {

    public void outputPurchaseLottoNumber(int buyCount, List<List<Integer>> buyLottoList) {
        System.out.println("\n" + buyCount / 1000 + "개를 구매했습니다.");
        for (List<Integer> lottoNumber : buyLottoList) {
            System.out.println(lottoNumber);
        }
    }

    public void outputLottoWinningStatistics() {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        for (Result result : Result.values()) {
            int matches = result.getMatches();
            String bonus = result.getStringBonus();
            String money = String.format("%,d", result.getMoney());
            int count = result.getCount();
            System.out.println(matches + "개 일치" + bonus + "(" + money + "원)" + " - " + count + "개");
        }
    }

    public void outputLateOfReturn(double lateOfReturn) {
        System.out.println("총 수익률은 " + String.format("%,.1f", lateOfReturn) + "%입니다.");
    }

}
