package lotto;

import java.util.Arrays;

public enum LottoRank {
    NONE(0, "일치하지않음", 0, false, 0),
    FIFTH(5, "3개 일치", 5_000, false, 3),
    FOURTH(4, "4개 일치", 50_000, false, 4),
    THIRD(3, "5개 일치", 1_500_000, false, 5),
    SECOND(2, "5개 일치, 보너스 볼 일치", 30_000_000, true, 5),
    FIRST(1, "6개 일치", 2_000_000_000, false, 6);

    private final int rank;
    private final String description;
    private final int prize;
    private final boolean matchBonus;
    private final int matchCount;

    LottoRank(int rank, String description, int prize, boolean matchBonus, int matchCount) {
        this.rank = rank;
        this.description = description;
        this.prize = prize;
        this.matchBonus = matchBonus;
        this.matchCount = matchCount;
    }

    public static LottoRank getLottoRank(int matchCount, boolean matchBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(i -> i.matchCount == matchCount && i.matchBonus == matchBonus)
                .findFirst()
                .orElse(NONE);
    }

    public int getRank() {
        return rank;
    }

    public String getDescription() {
        return description;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
