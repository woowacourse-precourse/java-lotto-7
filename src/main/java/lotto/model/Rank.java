package lotto.model;

public enum Rank{
    SMALL_MATCHES,
    THREE_MATCHES,
    FOUR_MATCHES,
    FIVE_MATCHES,
    FIVE_WITH_BONUS,
    SIX_MATCHES;

    public static Rank findRank(int answerAgreement, int bonusAgreement){
        if(answerAgreement==3){
            return Rank.THREE_MATCHES;
        } else if (answerAgreement ==4) {
            return Rank.FOUR_MATCHES;
        } else if (answerAgreement == 5){
            return checkBonusAgreement(bonusAgreement);
        } else if (answerAgreement == 6){
            return Rank.SIX_MATCHES;
        }
        return Rank.SMALL_MATCHES;
    }

    private static Rank checkBonusAgreement(int bonusAgreement) {
        if(bonusAgreement==1){
            return Rank.FIVE_WITH_BONUS;
        }
        return Rank.FIVE_MATCHES;
    }
}