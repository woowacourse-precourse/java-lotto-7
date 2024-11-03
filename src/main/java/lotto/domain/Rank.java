package lotto.domain;

public enum Rank {

    NONE(0,false,0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;
    private int count = 0;

    Rank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        count++;
    }

    public static Rank getRank(int matchCount, boolean matchBonus) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && rank.matchBonus == matchBonus) {
                return rank;
            }
        }
        return NONE;
    }

    @Override
    public String toString() {
        if (matchBonus) {
            return matchCount + "개 일치, 보너스 볼 일치 (" + String.format("%,d",prize) + "원) - " + count + "개";
        }
        return matchCount + "개 일치 (" + String.format("%,d",prize) + "원) - " + count + "개";
    }

}
