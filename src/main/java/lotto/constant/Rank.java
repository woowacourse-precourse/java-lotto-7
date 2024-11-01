package lotto.constant;

import java.util.function.BiFunction;

//Todo : 더 좋은 이름 찾기
public enum Rank {
    FIRST(6, false, 2000000000, (count, bonus) -> count == 6),
    SECOND(5, true, 30000000, (count, bonus) -> count == 5 && bonus),
    THIRD(5, false, 1500000, (count, bonus) -> count == 5 && !bonus),
    FOURTH(4, false, 50000, (count, bonus) -> count == 4),
    FIFTH(3, false, 5000, (count, bonus) -> count == 3),
    NONE(0, false, 0, (count, bonus) -> count <= 2);

    private final int matchingNumberCount;
    private final boolean isMatchingBonusNumber;
    private final int prizeMoney;
    private final BiFunction<Integer, Boolean, Boolean> criteria;

    Rank(int matchingNumberCount, boolean isMatchingBonusNumber, int prizeMoney,
         BiFunction<Integer, Boolean, Boolean> criteria) {
        this.matchingNumberCount = matchingNumberCount;
        this.isMatchingBonusNumber = isMatchingBonusNumber;
        this.prizeMoney = prizeMoney;
        this.criteria = criteria;
    }

    public int getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public boolean isMatchingBonusNumber() {
        return isMatchingBonusNumber;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean matchesCriteria(int matchedCount, boolean bonus) {
        return criteria.apply(matchedCount, bonus);
    }
}
