package lotto.util;

public enum LottoRank {
    FIFTH(5, 5_000),
    FOURTH(4, 50_000),
    THIRD(3, 1_500_000),
    SECOND(2, 30_000_000),
    FIRST(1, 2_000_000_000);

    private final int rank;
    private final int prize;

    LottoRank(int rank, int prize){
        this. rank = rank;
        this.prize = prize;
    }

    public int getRank(){
        return rank;
    }

    public int getPrize(){
        return prize;
    }
}
