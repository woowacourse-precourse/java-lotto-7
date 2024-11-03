package lotto.model;

import lotto.util.WinningDetails;

public class YieldCalculator {

    public static final String EMPTY_STRING = "";

    public static final String COMMA = ",";

    public String calculate(int lottoCount) {
        int totalPrize = getTotalPrize();
        int purchasedAmount = lottoCount * 1000;

        double yield = (double) totalPrize / purchasedAmount * 100;

        return String.format("%.1f", yield);
    }

    private int getTotalPrize() {
        int totalPrize = 0;

        for (WinningDetails rank : WinningDetails.values()) {
            String processedWinningPrize = rank.getWinningPrize().replace(COMMA, EMPTY_STRING);
            int winningPrize = Integer.parseInt(processedWinningPrize);
            int matchLottoCount = rank.getMatchLottoCount();

            totalPrize += winningPrize * matchLottoCount;
        }
        return totalPrize;
    }
}
