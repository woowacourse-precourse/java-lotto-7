package lotto;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;       // 매칭되는 번호의 개수
    private final int prize;            // 해당 등수의 상금
    private final boolean requiresBonus; // 보너스 번호 일치 필요 여부 (2등에만 해당)

    LottoRank(int matchCount, int prize) {
        this(matchCount, prize, false);
    }

    LottoRank(int matchCount, int prize, boolean requiresBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.requiresBonus = requiresBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoRank valueOf(int matchCount, boolean bonusMatch) {
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && (!rank.requiresBonus || bonusMatch)) {
                return rank;
            }
        }
        return NONE;
    }
}
