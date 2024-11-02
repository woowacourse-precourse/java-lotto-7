package lotto.enums;

public enum WinningType {
    FIRST(3, 5000, 0),
    SECOND(4, 50000, 0),
    THIRD(5, 15000000, 0),
    FOURTH_BONUS(5, 30000000, 0),
    FIFTH(6, 2000000000, 0);

    private final int matchCount;
    private final int prizeMoney;
    private int count;

    WinningType(int matchCount, int prizeMoney, int count){
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.count = count;
    }

    public int getMatchCount(){
        return matchCount;
    }

    public int getPrizeMoney(){
        return prizeMoney;
    }

    public int getCount(){
        return count;
    }

    public void countUp(){
//        if(matchCount == 3){
//            FIRST.count += 1;
//        }
//        if(matchCount == 4){
//            SECOND.count += 1;
//        }
//        if(matchCount == 5){
//            if(checkBonus){
//                FOURTH_BONUS.count += 1;
//            }
//            if(!checkBonus){
//                THIRD.count += 1;
//            }
//        }
//        if(matchCount == 6){
//            FIFTH.count += 1;
//        }

        this.count += 1;
    }
}
