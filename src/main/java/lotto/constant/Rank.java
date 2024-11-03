package lotto.constant;

import java.util.function.BiFunction;

public enum Rank {
    FIRST(6, false, 2_000_000_000, (count, bonus) -> count == 6),
    SECOND(5, true, 30_000_000, (count, bonus) -> count == 5 && bonus),
    THIRD(5, false, 1_500_000, (count, bonus) -> count == 5 && !bonus),
    FOURTH(4, false, 50_000, (count, bonus) -> count == 4),
    FIFTH(3, false, 5_000, (count, bonus) -> count == 3),
    NONE(0, false, 0, (count, bonus) -> count <= 2);

    private final int matchingNumber;
    private final boolean isMatchingBonusNumber;
    private final long prizeMoney;
    private final BiFunction<Integer, Boolean, Boolean> criteria;

    Rank(int matchingNumber, boolean isMatchingBonusNumber, long prizeMoney,
         BiFunction<Integer, Boolean, Boolean> criteria) {
        this.matchingNumber = matchingNumber;
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

    public long getPrizeMoney() {
        return prizeMoney;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d개 일치", matchingNumber));
        if (isMatchingBonusNumber) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(String.format(" (%,d원)", prizeMoney));
        return sb.toString();
    }
}
