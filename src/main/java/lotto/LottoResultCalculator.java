package lotto;

public class LottoResultCalculator {

    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final double PERCENTAGE_CONVERSION_FACTOR = 10.0;

    public static LottoRank determineRank(Lotto purchasedLottos, Lotto winningLotto, int bonusNumber) {
        int matchCount = purchasedLottos.getMatchCount(winningLotto);
        boolean matchBonus = purchasedLottos.contains(bonusNumber);
        return LottoRank.checkWinningStatus(matchCount, matchBonus);
    }

    public static double calculateReturnRate(int purchaseAmount, long totalWinnings) {
        return Math.round((totalWinnings / (double) purchaseAmount) * LOTTO_TICKET_PRICE) / PERCENTAGE_CONVERSION_FACTOR;
    }
}
