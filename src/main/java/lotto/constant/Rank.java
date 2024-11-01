package lotto.constant;

import java.util.function.BiFunction;

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


    /**
     * 현재 랭크가 주어진 조건(일치한 번호 개수와 보너스 번호 일치 여부)에 부합하는지 체크
     *
     * @param matchedCount 일치한 번호 개수
     * @param bonus        보너스 번호일치 여부
     * @return 기준에 부합하다면 True, 부합하지 않다면 False
     */
    public boolean matchesCriteria(int matchedCount, boolean bonus) {
        return criteria.apply(matchedCount, bonus);
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
}
