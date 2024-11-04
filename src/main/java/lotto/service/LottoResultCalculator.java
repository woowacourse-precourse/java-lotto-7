package lotto.service;

public class LottoResultCalculator {

    public static String determineRank(int matchCount, boolean isBonusMatch) {
        if (matchCount == 6) return "1등";
        if (matchCount == 5 && isBonusMatch) return "2등";
        if (matchCount == 5) return "3등";
        if (matchCount == 4) return "4등";
        if (matchCount == 3) return "5등";
        return "";
    }

}
