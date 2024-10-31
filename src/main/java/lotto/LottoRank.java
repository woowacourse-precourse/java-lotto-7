package lotto;

public enum LottoRank {
    RANK_1(6, false),
    RANK_2(5, true),
    RANK_3(5, false),
    RANK_4(4, false),
    RANK_5(3, false)
    ;

    private final int matchNumber;
    private final boolean bonusNumber;

    LottoRank(int matchNumber, boolean bonusNumber) {
        this.matchNumber = matchNumber;
        this.bonusNumber = bonusNumber;
    }

    static LottoRank getRank(int matchNumber, boolean bonusNumber) {
        for(LottoRank rank: values()) {
            if(rank.matchNumber == matchNumber && rank.bonusNumber == bonusNumber) {
                return rank;
            }
        }
        return null;
    }
}
