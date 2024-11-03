package lotto;

public enum LottoRank {
    RANK_1(1,2_000_000_000, "6개 일치"),
    RANK_2(2,30_000_000,"5개 일치, 보너스 볼 일치"),
    RANK_3(3,1_500_000,"5개 일치"),
    RANK_4(4,50_000,"4개 일치"),
    RANK_5(5,5_000,"3개 일치");

    private final int rank;
    private final int prize;
    private final String condition;

    LottoRank(int rank, int prize, String condition) {
        this.rank = rank;
        this.prize = prize;
        this.condition = condition;
    }

    public int getRank(){
        return rank;
    }

    public int getPrize() {
        return prize;
    }

    public String toString(){
        return condition+String.format(" (%,d원)",prize);
    }
}

