package lotto.model;

public class LottoResult {
    private final Rank rank;

    private LottoResult(Rank rank) {
        this.rank = rank;
    }

    public static LottoResult valueOf(int answerAgreement, int bonusAgreement){
        return new LottoResult(Rank.findRank(answerAgreement, bonusAgreement));
    }

    public Rank getRank(){
        return rank;
    }
}
