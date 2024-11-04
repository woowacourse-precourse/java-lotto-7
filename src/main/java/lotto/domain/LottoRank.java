package lotto.domain;

public enum LottoRank {
    FIRST(6,2000000000),
    SECOND(5,30000000,true),
    THIRD(5,1500000),
    FOURTH(4,50000),
    FIFTH(3,5000),
    NONE(0,0);

    private final int matchCount;
    private final int prize;
    private final boolean matchBonus;

    LottoRank(int matchCount, int prize){
        this(matchCount,prize,false);
    }
    LottoRank(int matchCount, int prize, boolean matchBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.matchBonus = matchBonus;
    }
    public int getPrize(){
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }
    // 로또 일치하는 개수 & 보너스 번호 일치 여부에 따라서 등수 반환
    public static LottoRank valueOf(int matchCount, boolean matchBonus){
        if(matchCount == SECOND.matchCount && matchBonus){
            return SECOND;
        }
        for(LottoRank rank : values()){
            if(rank.matchCount == matchCount && rank != SECOND){
                return rank;
            }
        }
        return NONE;
    }
}

