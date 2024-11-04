package Calculator;

import java.util.Map;

public class Profit {
    public double calculate(Map<Integer, Integer> ranks, int money) {
        int cnt = money / 1000;

        int totalEarnMoney = 0;
        for (int i = 1; i < 6; i++) {
            totalEarnMoney = totalEarnMoney + getPrice(i, ranks.get(i));
        }

        double profit = totalEarnMoney / (double) money * 100;
        profit = Math.round(profit * 100) / 100.0;

        return profit;
    }

    private int getPrice(int rank, int cnt) {
        final int first = 2000000000;
        final int second = 30000000;
        final int third = 1500000;
        final int fourth = 50000;
        final int fifth = 5000;

        if (rank == 1) {
            return first * cnt;
        }
        if (rank == 2) {
            return second * cnt;
        }
        if (rank == 3) {
            return third * cnt;
        }
        if (rank == 4) {
            return fourth * cnt;
        }
        if (rank == 5) {
            return fifth * cnt;
        }

        return 0;
    }
}
