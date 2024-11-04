package lotto.constant;

public enum PrizeTier  {
    FIRST(6,false,2_000_000_000),
    SECOND(5,true,30_000_000),
    THIRD(5,false,1_500_000),
    FORTH(4,false,50_000),
    FIFTH(3,false,5_000),
    NONE(2,false,0);

    private final int matchCount;
    private final boolean bonusMatchRequire;
    private final int money;

    private PrizeTier (int matchCount, boolean bonusMatchRequire,int money){
        this.matchCount = matchCount;
        this.bonusMatchRequire = bonusMatchRequire;
        this.money = money;
    }

    public int getMatchCount(){
        return this.matchCount;
    }

    public boolean getBonusMatchRequire(){
        return this.bonusMatchRequire;
    }

    public int getPrizeMoney(){
        return this.money;
    }



    static public PrizeTier  checkPrizeTier (int matchCount, boolean isBonusMatch){

        PrizeTier result = checkPrizeWithoutBonusNumber(matchCount);
        if(result == PrizeTier.THIRD){
            result = checkSecondOrThird(matchCount,isBonusMatch);
        }

        return result;
    }

    static public PrizeTier[] getWinningPrizeTierValues(){
        return new PrizeTier[]{FIFTH, FORTH, THIRD, SECOND, FIRST};
    }

    static private PrizeTier checkSecondOrThird(int matchCount, boolean isBonusMatch){
        if(matchCount== SECOND.matchCount
                &&isBonusMatch == SECOND.bonusMatchRequire){
            return PrizeTier.SECOND;
        }

        if(matchCount== THIRD.matchCount){
            return PrizeTier.THIRD;
        }

        return PrizeTier.NONE;
    }

    static private PrizeTier checkPrizeWithoutBonusNumber(int matchCount){
        if(matchCount== FIRST.matchCount){
            return PrizeTier.FIRST;
        }
        if(matchCount== THIRD.matchCount){
            return PrizeTier.THIRD;
        }
        if(matchCount== FORTH.matchCount) {
            return PrizeTier.FORTH;
        }
        if(matchCount== FIFTH.matchCount){
            return PrizeTier.FIFTH;
        }
        return PrizeTier.NONE;
    }
}
