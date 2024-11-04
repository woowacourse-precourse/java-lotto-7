package enums;

public enum LottoRank {
    FIRST(1, 2000000000),
    SECOND(2, 30000000),
    THIRD(3, 1500000),
    FOURTH(4, 50000),
    FIVE(5, 5000),
    NONE(6, 0);

    private final int rank;
    private final int prize;

    LottoRank(int rank, int prize){
        this.rank = rank;
        this.prize = prize;
    }

    public int getRank(){
        return rank;
    }

    public int getPrize(){
        return prize;
    }
}
