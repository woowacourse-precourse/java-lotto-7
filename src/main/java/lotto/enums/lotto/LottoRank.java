package lotto.enums.lotto;

public enum LottoRank {
    FIFTH(3, false, 5_000, "3개 일치 (5,000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)");

    private final int matchCount;
    private final boolean bonus;
    private final int prize;
    private final String description;

    LottoRank(int matchCount, boolean bonus, int prize, String description) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.prize = prize;
        this.description = description;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return FIRST;
        }

        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }

        if (matchCount == 5) {
            return THIRD;
        }

        if (matchCount == 4) {
            return FOURTH;
        }

        if (matchCount == 3) {
            return FIFTH;
        }

        return null;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}
