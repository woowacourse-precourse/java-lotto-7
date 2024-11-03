package lotto.View;

import lotto.Model.Lotto;
import lotto.Model.Rank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class Output {
    public static void LottoOutput(List<Lotto> Lottos) {
        for (Lotto lotto : Lottos) {
            System.out.println(lotto.GetNumbers());
        }
    }

    public static void ResultOutput(Map<Integer, Integer> result) {
        DecimalFormat formatter = new DecimalFormat("###,###");

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Rank rank : Rank.values()) {
            String Agrrement = rank.GetAgreement();
            String ResultMoney = formatter.format(rank.GetWinningMoney());
            int countResult = result.get(rank.GetWinningMoney());
            System.out.println(Agrrement + " (" + ResultMoney + "원) - " + countResult +"개");
        }
    }

    public static void MoneyRate(double rateOfMoney) {
        DecimalFormat formatter = new DecimalFormat("#,##0.0");
        System.out.println("총 수익률은 "+ formatter.format(rateOfMoney) + "%입니다.");
    }

    public static void ErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
        System.out.println();
    }
}
