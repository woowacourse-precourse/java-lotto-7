package lotto;

import java.util.Map;

public class CalculateRevenue {
    private final Map<Float, Integer> rateOfReturn;
    private final int totalSpent;
    private final int percentage = 100;


    public CalculateRevenue(Map<Float, Integer> rateOfReturn, int totalSpent) {
        this.rateOfReturn = rateOfReturn;
        this.totalSpent = totalSpent;
        printRevenue();
    }

    private void printRevenue() {
        float totalWinnings = calculateTotalWinnings();
        float revenue = calculateRevenue(totalWinnings);

        System.out.printf("총 수익률은 %.1f%%입니다.\n", revenue);
    }

    public float calculateTotalWinnings() {
        float totalWinnings = 0;
        for (Map.Entry<Float, Integer> entry : rateOfReturn.entrySet()) {
            float prize = entry.getKey();
            int count = entry.getValue();
            totalWinnings += prize * count;
        }
        return totalWinnings;
    }

    public float calculateRevenue(float totalWinnings) {
        return (totalWinnings / totalSpent) * percentage;
    }
}
