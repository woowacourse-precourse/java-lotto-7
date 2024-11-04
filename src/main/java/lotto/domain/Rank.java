package lotto.domain;

public enum Rank {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    LOSE(0, 0, false);
    private final int prize;
    private final int matchLotto;
    private final boolean matchBonus;

    Rank(int prize, int matchLotto, boolean matchBonus) {
        this.prize = prize;
        this.matchLotto = matchLotto;
        this.matchBonus = matchBonus;
    }
    public int getMatchLotto(){
        return matchLotto;
    }

    public int getPrize(){
        return prize;
    }
    public static Rank assign(int matchLotto, boolean matchBonus) {
        if(matchLotto == 6){ return FIRST; }
        if(matchLotto == 5 && matchBonus){ return SECOND; }
        if(matchLotto == 5){ return THIRD; }
        if(matchLotto == 4){ return FOURTH; }
        if(matchLotto == 3){ return FIFTH; }
        return LOSE;
    }
}