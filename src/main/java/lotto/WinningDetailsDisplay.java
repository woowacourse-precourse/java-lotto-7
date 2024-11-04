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

    public double calculateRate (int price, Map<WinningType, Integer> result) {
        int sum = 0;
        for (ResultType type : ResultType.values()) {
            WinningType winningType = WinningType.fromCount(type.getCount());
            int count = result.getOrDefault(winningType, 0);
            sum += (type.getReward()*count);
        }

        double rate = (double)sum/price * 100;
        return Math.round(rate * 10) / 10.0;
    }

    public void printRate(int price, Map<WinningType, Integer> result) {
        double rate = calculateRate(price, result);
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
