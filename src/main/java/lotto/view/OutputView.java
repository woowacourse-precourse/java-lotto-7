package lotto.view;

import lotto.model.Lotto;

import java.util.List;

import static lotto.constants.Constants.*;

public class OutputView {

    public static void printLottoNumbers(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatistics(int[] rankCount) {
        System.out.println();
        System.out.println("당첨 통계\n---");
        // 각 등수별 출력 문구에 맞게 출력
        System.out.println(FIFTH_PLACE.getValue() + "개 일치 (" + String.format("%,d",FIFTH_PLACE_PRIZE.getValue()) + "원) - " + rankCount[5] + "개");
        System.out.println(FOURTH_PLACE.getValue() + "개 일치 (" + String.format("%,d",FOURTH_PLACE_PRIZE.getValue()) + "원) - " + rankCount[4] + "개");
        System.out.println(THIRD_PLACE.getValue() + "개 일치 (" + String.format("%,d",THIRD_PLACE_PRIZE.getValue()) + "원) - " + rankCount[3] + "개");
        System.out.println(SECOND_PLACE.getValue() + "개 일치, 보너스 볼 일치 (" + String.format("%,d",SECOND_PLACE_PRIZE.getValue()) + "원) - " + rankCount[2] + "개");
        System.out.println(FIRST_PLACE.getValue() + "개 일치 (" + String.format("%,d",FIRST_PLACE_PRIZE.getValue()) + "원) - " + rankCount[1] + "개");
    }

    public static void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }
}
