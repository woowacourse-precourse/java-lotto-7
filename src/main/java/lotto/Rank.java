package lotto;

public enum Rank {
    FIRST(6,false,2000000000),
    SECOND(5,true,30000000),
    THIRD(5,false,1500000),
    FOURTH(4,false,50000),
    FIFTH(3,false,5000);

    private final int numberMatch;
    private final boolean bonus;
    private final int prize;

    Rank(int numberMatch, boolean bonus, int prize){
        this.numberMatch = numberMatch;
        this.bonus = bonus;
        this.prize = prize;
    }

    public int getNumberMatch(){
        return numberMatch;
    }
    public boolean getBonus(){
        return bonus;
    }
    public int getPrize(){
        return prize;
    }

    public static Rank getRank(int numberMatch, boolean bonus){
        for(Rank rank : Rank.values()){
            if(rank.getNumberMatch()==numberMatch && rank.getBonus()==bonus){
                return rank;
            }
        }

    }



}
