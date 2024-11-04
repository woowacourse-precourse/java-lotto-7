package lotto.domain;

public enum LottoRank {
    NOTHING(0,"0원"),
    FIFTH(3, "5,000원"),
    FOURTH(4, "50,000원"),
    THIRD(5, "1,500,000원"),
    SECOND(5, "30,000,00원"),
    FIRST(6, "2,000,000,000원");

    private final Integer matchNumber;
    private final String reward;

    LottoRank(Integer matchNumber, String reward){
        this.matchNumber = matchNumber;
        this.reward = reward;
    }

    public Integer getMatchNumber() {
        return matchNumber;
    }

    public String getReward() {
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
