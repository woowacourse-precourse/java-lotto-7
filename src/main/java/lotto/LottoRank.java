package lotto;

public enum LottoRank {
    NONE(0, 0, "미당첨"),
    THREE(3, 5_000, "3개 일치"),
    FOUR(4, 50_000, "4개 일치"),
    FIVE(5, 1_500_000, "5개 일치"),
    FIVE_BONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    SIX(6, 2_000_000_000, "6개 일치");

    private final int matchCount;
    private final int prize;
    private final String description;

    LottoRank(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public static LottoRank getLottoRank(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return SIX;
        }
        if (matchCount == 5 && matchBonus) {
            return FIVE_BONUS;
        }
        if (matchCount == 5) {
            return FIVE;
        }
        if (matchCount == 4) {
            return FOUR;
        }
        if (matchCount == 3) {
            return THREE;
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

}
