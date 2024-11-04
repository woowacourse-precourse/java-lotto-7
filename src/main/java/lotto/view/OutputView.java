package lotto.view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.model.LottoPrize;

public class OutputView {
    public static void printPurchaseAmountMsg() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinnerLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printMatchResult(Map<LottoPrize, Integer> prizeCount) {
        System.out.println("당첨 통계");
        System.out.println("---");

        LottoPrize[] orderedPrizes = prizeCount.keySet().toArray(new LottoPrize[0]);
        Arrays.sort(orderedPrizes, Comparator.comparingInt(LottoPrize::getMatchCount));
        for (LottoPrize prize : orderedPrizes) {
            if (prize != prize.NONE) {
                System.out.printf("%d개 일치%s (%,d원) - %d개\n",
                        prize.getMatchCount(),
                        prize.isRequiresBonus() ? ", 보너스 볼 일치" : "",
                        prize.getPrize(),
                        prizeCount.get(prize));
            }
        }
    }

    public static void printProfit(double profit) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profit);
    }
}
