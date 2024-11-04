package lotto.domain;

public record LottoRank(int rank,
                        int prizeAmount,
                        int winningNumberCount,
                        boolean shouldMatchBonusNumber) {

    public boolean isWinning(int numberCount, boolean isMatchedBonusNumber) {
        if (numberCount != winningNumberCount) {
            return false;
        }

        if (!shouldMatchBonusNumber) {
            return true;
        }

        return isMatchedBonusNumber;
    }
}
