package lotto.entity;

import java.util.function.BiPredicate;

public enum Rank { // 등수 enum 사용 예정
    FIRST(6, false, 2_000_000_000, (count, bonus) -> count == 6),
    SECOND(5, true, 30_000_000, (count, bonus) -> count == 5 && bonus),
    THIRD(5, false, 1_500_000, (count, bonus) -> count == 5 && !bonus),
    FOURTH(4, false, 50_000, (count, bonus) -> count == 4),
    FIFTH(3, false, 5_000, (count, bonus) -> count == 3),
    NONE(0, false, 0, (count, bonus) -> count <= 2);

    private final int matchCount; // 일치해야 하는 번호 개수
    private final boolean hasBonus; // 보너스 번호 여부
    private final long prize; // 상금
    private final BiPredicate<Integer, Boolean> criteria; // 등수 결정 조건

    Rank(int matchCount, boolean hasBonus, long prize, BiPredicate<Integer, Boolean> criteria) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
        this.criteria = criteria;
    }

    // 주어진 count와 bonus에 따라 해당 Rank 반환
    public static Rank getRank(int count, boolean bonus) {
        for (Rank rank : values()) {
            if (rank.criteria.test(count, bonus)) {
                return rank;
            }
        }
        return NONE; // 조건에 맞는 Rank가 없을 경우 NONE 반환
    }

    // 일치 여부를 판단하는 메서드
    public boolean isMatched(int count, boolean bonus) {
        return criteria.test(count, bonus);
    }

    // Getter methods
    public int getMatchCount() {
        return matchCount;
    }

    public boolean hasBonus() {
        return hasBonus;
    }

    public long getPrize() {
        return prize;
    }
}
