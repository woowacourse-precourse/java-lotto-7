package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printPurchased(Money money, List<Lotto> lottos){
        int amount = money.getAmount();
        System.out.println(amount + "개를 구매했습니다.");
        for (int i = 0; i < amount; i++){
            System.out.println(lottos.get(i));
        }
        System.out.println();
    }

    public static void printResult(Map<Rank, Integer> result, double profit){
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()){
            System.out.println(rank + " - " + result.get(rank) + "개");
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", profit);
    }
}
