package lotto.view;

import java.util.Map;

public class Winning_OutputView {
    public void printRanks(Map<Integer, Integer> ranks) {

        //Map: key를 등수 - value를 해당 개수로 설정하자. 그리고 등수에 따른 금액
        //아냐. Map의 key를 enum으로 넣자
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + + "개");
        System.out.println("4개 일치 (50,000원) - " +  + "개");
        System.out.println("5개 일치 (1,500,000원) - " +  + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " +  + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " +  + "개");
        System.out.println();
    }

    public void printRateOfWinning(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
