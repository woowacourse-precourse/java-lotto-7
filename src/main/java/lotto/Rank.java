package lotto;

public enum Rank {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false);

    private final int matchCount;
    private final int prize;
    private final boolean bonusMatch;

    Rank(int matchCount, int prize, boolean bonusMatch) {
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

    public boolean getBonusMatch() {
        return bonusMatch;
    }

    public static Rank fromValue(int matchCount, boolean bonusMatch) {
        for(Rank constant : Rank.values()) {
            if(constant.getMatchCount() == matchCount && constant.getBonusMatch() == bonusMatch){
                return constant;
            }
        }
        throw new IllegalArgumentException("enum에 해당 값을 가진 상수가 없습니다.");
    }
}
