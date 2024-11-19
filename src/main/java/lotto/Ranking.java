package lotto;

import java.util.Arrays;

public enum Ranking {
    NO_RANK(0, false, 0),
    FIFTH_PLACE(3, false, 5000),
    FOURTH_PLACE(4, false, 50000),
    THIRD_PLACE(5, false, 1500000),
    SECOND_PLACE(5, true, 30000000),
    FIRST_PLACE(6, false, 2000000000);

    private final int hitCount;
    private final boolean bonusHit;
    private final long prize;

    Ranking(int hitCount, boolean bonusHit, long prize) {
        this.hitCount = hitCount;
        this.bonusHit = bonusHit;
        this.prize = prize;
    }

    public static String getEnumName(int hitCount, boolean bonusHit) {
        Ranking ranking = Arrays.stream(Ranking.values())
                .filter(rank -> rank.hitCount == hitCount && rank.bonusHit == bonusHit)
                .findFirst().orElse(NO_RANK);
        return ranking.name();
    }

    public String getRankingMessage(int count) {
        String bonus = "";
        if (this.bonusHit) {
            bonus = ", 보너스 볼 일치";
        }

        return String.format("%d개 일치%s (%,d원) - %d개", this.hitCount, bonus, this.prize, count);
    }

    public long getPrize() {
        return this.prize;
    }
}
