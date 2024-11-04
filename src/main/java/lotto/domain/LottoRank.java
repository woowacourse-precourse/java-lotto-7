package lotto.domain;

public enum LottoRank {
    FAIL(2, 0L, false),
    THREE(3, 5000L, false),
    FOUR(4, 50000L, false),
    FIVE(5, 1500000L, false),
    FIVE_BONUS(5, 30000000L, true),
    SIX(6, 2000000000L, false);

    private final Integer matchedCount;
    private final Long prize;
    private final boolean isBonusNumber;

    LottoRank(Integer matchedCount, Long prize, boolean isBonusNumber) {
        this.matchedCount = matchedCount;
        this.prize = prize;
        this.isBonusNumber = isBonusNumber;
    }

    public static LottoRank matchNumbers(Lotto lotto, WinLotto winLotto) {
        Integer matchingCount = lotto.getMatchNumberCount(winLotto.getNumbers());

        if (matchingCount.equals(SIX.matchedCount)) return SIX;
        if (matchingCount.equals(FIVE_BONUS.matchedCount) && lotto.hasNumber(winLotto.getBonusNumber()))
            return FIVE_BONUS;
        if (matchingCount.equals(FIVE.matchedCount)) return FIVE;
        if (matchingCount.equals(FOUR.matchedCount)) return FOUR;
        if (matchingCount.equals(THREE.matchedCount)) return THREE;
        return FAIL;
    }

    public Long getPrize() {
        return prize;
    }

    public Integer getMatchedCount() {
        return matchedCount;
    }

    public boolean isBonusNumber() {
        return isBonusNumber;
    }
}
