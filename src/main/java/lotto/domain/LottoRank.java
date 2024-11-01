package lotto.domain;

import java.util.List;

public enum LottoRank {
    FAIL(2, 0, false),
    THREE(3, 5000, false),
    FOUR(4, 50000, false),
    FIVE(5, 1500000, false),
    FIVE_BONUS(5, 30000000, true),
    SIX(6, 2000000000, false);

    private final Integer matchedCount;
    private final Integer prize;
    private final boolean isBonusNumber;

    LottoRank(Integer matchedCount, Integer prize, boolean isBonusNumber) {
        this.matchedCount = matchedCount;
        this.prize = prize;
        this.isBonusNumber = isBonusNumber;
    }


    public static LottoRank matchNumbers(Lotto lotto, List<Integer> winNumbers, int bonusNumber) {
        Integer matchingCount = lotto.getMatchNumberCount(winNumbers);

        if (matchingCount.equals(SIX.matchedCount)) return SIX;
        if (matchingCount.equals(FIVE_BONUS.matchedCount) && lotto.hasNumber(bonusNumber)) return FIVE_BONUS;
        if (matchingCount.equals(FIVE.matchedCount)) return FIVE;
        if (matchingCount.equals(FOUR.matchedCount)) return FOUR;
        if (matchingCount.equals(THREE.matchedCount)) return THREE;
        return FAIL;
    }

    public Integer getPrize() {
        return prize;
    }

    public Integer getMatchedCount() {
        return matchedCount;
    }

    public boolean isBonusNumber() {
        return isBonusNumber;
    }
}
