package lotto.view;

import lotto.model.Prize;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printLottoNumbers(List<String> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (String lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printWinningResults(Map<Prize, Integer> prizeCount, double returnRate) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Prize prize : Prize.values()) {
            if (prize == Prize.NONE) continue;
            System.out.println(prize.getMessage() + " - " + prizeCount.get(prize) + "개");
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", returnRate);
    }
}
