package lotto.model;

public enum Rank {
    FIFTH(0,5000),
    FOURTH(1,50000),
    THIRD(2,1500000),
    SECOND(3,30000000),
    FIRST(4,2000000000);

    private final int index;
    private final int prize;


    Rank(int index,int prize) {
        this.index=index;
        this.prize = prize;
    }

    public int getIndex() {
        return index;
    }

    public int getPrize() {
        return prize;
    }
}
