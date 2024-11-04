package lotto.service;

public class ProfitService {
    public static int calculateProfit(int prize, int count) {
        return prize * count;
    }

    public static double calculateProfitRate(int profit, int money) {
        return (double) profit / money * 100;
    }
}
