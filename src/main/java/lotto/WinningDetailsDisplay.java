package lotto;

import java.util.Map;

public class WinningDetailsDisplay {
    public void printWinningDetails (Map<WinningType, Integer> result) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        for (ResultType type : ResultType.values()) {
            WinningType winningType = WinningType.fromCount(type.getCount());
            int count = result.getOrDefault(winningType, 0);

            System.out.println(type.getValue() + " (" + type.getFormattedReward() + "원) - " + count + "개");
        }
    }

    public void printRate (int price, Map<WinningType, Integer> result) {  // 수익률 출력
        int sum = 0;
        for (ResultType type : ResultType.values()) {
            WinningType winningType = WinningType.fromCount(type.getCount());
            int count = result.getOrDefault(winningType, 0);
            sum += (type.getReward()*count);
        }

        double rate = (double)sum/price * 100;
        double roundedRate = Math.round(rate * 10) / 10.0;
        System.out.println("총 수익률은 " + roundedRate + "%입니다.");
    }
}
