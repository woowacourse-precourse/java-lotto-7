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
        /*TODO
        * 함수 줄 줄이기
        * - 방법1) hashMap을 사용하여 맵핑한다.*/
        if(matchCount== FIRST.matchCount){
            return PrizeTier .FIRST;
        }

        if(matchCount== SECOND.matchCount
        &&isBonusMatch == SECOND.bonusMatchRequire){
            return PrizeTier .SECOND;
        }

        if(matchCount== THIRD.matchCount){
            return PrizeTier .THIRD;
        }

        if(matchCount== FORTH.matchCount) {
            return PrizeTier .FORTH;
        }

        if(matchCount== FIFTH.matchCount){
            return PrizeTier .FIFTH;
        }

        return PrizeTier .NONE;
    }

    static public PrizeTier[] getWinningPrizeTierValues(){
        return new PrizeTier[]{FIFTH, FORTH, THIRD, SECOND, FIRST};
    }
}
