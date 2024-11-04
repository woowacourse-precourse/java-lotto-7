package lotto;

public enum LottoRank {
    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5, 30_000_000, true),
    THIRD_PRIZE(5, 1_500_000),
    FOURTH_PRIZE(4, 50_000),
    FIFTH_PRIZE(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;
    private final boolean bonusMatch;

    // 기본 생성자
    LottoRank(int matchCount, int prize) {
        this(matchCount, prize, false);
    }

    // 보너스 번호를 포함하는 생성자
    LottoRank(int matchCount, int prize, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    // 주어진 일치 개수와 보너스 일치 여부에 따라 적합한 등급 반환
    public static LottoRank valueOf(int matchCount, boolean bonusMatch) {
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && rank.bonusMatch == bonusMatch) {
                return rank;
            }
        }
        if (matchCount >= 3) {
            return valueOf(matchCount, false);
        }
        return NONE;
    }
}
