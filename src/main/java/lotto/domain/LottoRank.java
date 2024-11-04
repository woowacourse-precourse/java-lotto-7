package lotto.domain;

public enum LottoRank {
    NOTHING(0,0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 3000000),
    FIRST(6, 2000000000);

    private final Integer matchNumber;
    private final Integer reward;

    LottoRank(Integer matchNumber, Integer reward){
        this.matchNumber = matchNumber;
        this.reward = reward;
    }

    public Integer getMatchNumber() {
        return matchNumber;
    }

    public Integer getReward() {
        return reward;
    }

    public static LottoRank getRank(int count, boolean bonusCheck){
        for(LottoRank rank : values()){
            if(count == SECOND.matchNumber && bonusCheck){
                return SECOND;
            }
            if(count == THIRD.matchNumber && !bonusCheck){
                return THIRD;
            }
            if(rank.matchNumber == count){
                return rank;
            }
        }
        return NOTHING;
    }
}
