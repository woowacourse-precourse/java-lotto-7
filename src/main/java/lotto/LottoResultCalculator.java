package lotto;

public class LottoResultCalculator {

    public static LottoRank determineRank(Lotto purchasedLottos, Lotto winningLotto, int bonusNumber) {
        int matchCount = purchasedLottos.getMatchCount(winningLotto);
        boolean matchBonus = purchasedLottos.contains(bonusNumber);
        return LottoRank.checkWinningStatus(matchCount, matchBonus);
    }

    public static double calculateReturnRate(int purchaseAmount, long totalWinnings) {
        return Math.round((totalWinnings / (double) purchaseAmount) * 1000) / 10.0;
    }
}
