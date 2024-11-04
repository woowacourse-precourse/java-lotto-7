package lotto;

public enum LottoMatch {
    FIRST(6, false, 2_000_000_000),       
    SECOND(5, true, 30_000_000),          
    THIRD(5, false, 1_500_000),           
    FOURTH(4, false, 50_000),             
    FIFTH(3, false, 5_000),               
    NONE(0, false, 0);                    

    private final int matchCount;
    private final boolean requiresBonus;
    private final int prize;

    LottoMatch(int matchCount, boolean requiresBonus, int prize) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoMatch valueOf(int matchCount, boolean matchBonus) {
        for (LottoMatch match : values()) {
            if (match.matchCount == matchCount && match.requiresBonus == matchBonus) {
                return match;
            }
        }
        return NONE;
    }
}
