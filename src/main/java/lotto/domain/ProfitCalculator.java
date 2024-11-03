package lotto.domain;

public class ProfitCalculator {

    public static double calculateProfitRate(int totalWinnings, int purchaseAmount) {
        return ((double) totalWinnings / purchaseAmount) * 100;
    }
}
