package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST("6개 일치", 6, 2_000_000_000, false),
    SECOND("5개 일치, 보너스 볼 일치", 5, 30_000_000, true),
    THIRD("5개 일치", 5, 1_500_000, false),
    FOURTH("4개 일치", 4, 50_000, false),
    FIFTH("3개 일치", 3, 5_000, false),
    FAIL("0개 일치", 0,0, false);

    private final String label;
    private final int matchCount;
    private final int prize;
    private final boolean hasBonus;

    Rank(String label, int matchCount, int prize, boolean hasBonus) {
        this.label = label;
        this.matchCount = matchCount;
        this.prize = prize;
        this.hasBonus = hasBonus;
    }

    public String getLabel(){
        return label;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize(){
        return prize;
    }
    public boolean hasBonus(){
        return hasBonus;
    }

    public static Rank from(int matchCount, boolean bonusMatch) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> rank.hasBonus == bonusMatch)
                .findFirst()
                .orElse(FAIL);
    }
}
