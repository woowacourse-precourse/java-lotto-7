package lotto.service;

public class LottoResultCalculator {

    private static final int FIRST_PRIZE = 2_000_000_000;
    private static final int SECOND_PRIZE = 30_000_000;
    private static final int THIRD_PRIZE = 1_500_000;
    private static final int FOURTH_PRIZE = 50_000;
    private static final int FIFTH_PRIZE = 5_000;

    public static String determineRank(int matchCount, boolean isBonusMatch) {
        if (matchCount == 6) return "1등";
        if (matchCount == 5 && isBonusMatch) return "2등";
        if (matchCount == 5) return "3등";
        if (matchCount == 4) return "4등";
        if (matchCount == 3) return "5등";
        return "";
    }

    public static int calculateTotalPrize(int firstCount, int secondCount, int thirdCount, int fourthCount, int fifthCount) {
        return firstCount * FIRST_PRIZE +
                secondCount * SECOND_PRIZE +
                thirdCount * THIRD_PRIZE +
                fourthCount * FOURTH_PRIZE +
                fifthCount * FIFTH_PRIZE;
    }

    public static double calculateRevenueRate(int totalPrize, int purchaseAmount) {
        double yield = (double) totalPrize / purchaseAmount * 100;
        return Math.round(yield * 100.0) / 100.0;
    }
}
