package lotto.domain;

public enum Ranking {
    FIFTH(3, false,"5,000", 5000, 0),
    FOURTH(4, false,"50,000", 50000, 1),
    THIRD(5,false, "1,500,000", 1500000, 2),
    SECOND(5,true,"30,000,000", 30000000, 3),
    FIRST(6, false,"2,000,000,000", 2000000000, 4);
    private final String wonPrize;
    private final int commonNumber;
    private final boolean matchBonus;
    private final int prize;
    private final int index;
    Ranking(int commonNumber,boolean matchBonus, String wonPrize, int prize, int index){
        this.commonNumber = commonNumber;
        this.matchBonus = matchBonus;
        this.wonPrize = wonPrize;
        this.prize = prize;
        this.index = index;
    }
    public static Ranking findRank(int commonCount, boolean hasBonus){
        for(Ranking rank:Ranking.values()){
            if(rank.getCommonNumber() == commonCount && rank.matchBonus == hasBonus){
                return rank;
            }
        }
        return null;
    }
    public int getCommonNumber() {
        return commonNumber;
    }

    public String getWonPrize() {
        return wonPrize;
    }

    public int getPrize() {
        return prize;
    }

    public int getIndex() {
        return index;
    }
    @Override
    public String toString() {
        return String.format("%d개 일치 (%s원)", commonNumber, wonPrize);
    }
}