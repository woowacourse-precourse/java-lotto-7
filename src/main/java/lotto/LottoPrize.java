package lotto;

import java.util.List;

public enum LottoPrize {
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int numberMatchCount;
    private final boolean bonusNumberRequired;
    private final int prize;

    LottoPrize(int numberMatchCount, boolean bonusNumber, int prize) {
        this.numberMatchCount = numberMatchCount;
        this.bonusNumberRequired = bonusNumber;
        this.prize = prize;
    }

    public static void getIndividualResult(int matchCount, boolean matchBonusNumber, List<Integer> prizeCount) {
        for (LottoPrize rank : LottoPrize.values()) {
            if (rank.numberMatchCount == matchCount && rank.bonusNumberRequired == matchBonusNumber) {
                prizeCount.set(rank.ordinal(), prizeCount.get(rank.ordinal()) + 1);
            }
        }
    }
}
