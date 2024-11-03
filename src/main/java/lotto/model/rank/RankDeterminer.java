package lotto.model.rank;

public class RankDeterminer {
    public Rank determine(int matchingAmount, boolean matchesBonusNumber) {
        for (Rank rank : Rank.values()) {
            if (rank.getMatchingAmount() == matchingAmount) {
                return fromMatchingAmountAndBonusNumber(rank, matchingAmount, matchesBonusNumber);
            }
        }
        return Rank.FAIL;
    }

    private Rank fromMatchingAmountAndBonusNumber(Rank rank, int matchingAmount,
                                                  boolean matchesBonusNumber) {
        if (rank.isWithBonusNumber()) {
            if (matchesBonusNumber) {
                return rank;
            }
            return Rank.findByRank(rank.getRank() + 1);
        }
        return rank;
    }
}
