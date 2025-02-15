package lotto;

public enum Ranking {
    FIRST(6,2000000000),
    SECOND(5,30000000),
    THIRD(5,1500000),
    FOURTH(4,50000),
    FIFTH(3,5000),
    NOLUCK(0,0);

    private final int matchCount;
    private final int price;

    Ranking(int matchCount, int price){
        this.matchCount = matchCount;
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public int getMatchCount(){
        return matchCount;
    }
}
