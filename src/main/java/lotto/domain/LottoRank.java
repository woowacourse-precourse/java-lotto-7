package lotto.domain;

public enum LottoRank {
    FIRST_RANK(2000000000),
    SECOND_RANK(30000000),
    THIRD_RANK(1500000),
    FOURTH_RANK(50000),
    FIFTH_RANK(5000);

    private final int prizeAmount;

    LottoRank(int prizeAmount){
        this.prizeAmount = prizeAmount;
    }

    public int getPrizeAmount() {
        return this.prizeAmount;
    }
}
