package lotto.domain;

public enum LottoRank {
    FIRST_RANK(2000000000, "6개 일치 (2,000,000,000원) - "),
    SECOND_RANK(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_RANK(1500000, "5개 일치 (1,500,000원) - "),
    FOURTH_RANK(50000, "4개 일치 (50,000원) - "),
    FIFTH_RANK(5000, "3개 일치 (5,000원) - ");

    private final int prizeAmount;
    private final String message;

    LottoRank(int prizeAmount, String message){
        this.prizeAmount = prizeAmount;
        this.message = message;
    }

    public int getPrizeAmount() {
        return this.prizeAmount;
    }

    public String getMessage(){
        return this.message;
    }
}
