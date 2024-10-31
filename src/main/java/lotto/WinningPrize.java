package lotto;

public enum WinningPrize {
    FIRST(6,0,2_000_000_000,0),
    SECOND(5,1,30_000_000,0),
    THIRD(5,0,1_500_000,0),
    FORTH(4,0,50_000,0),
    FIFTH(3,0,5_000,0);

    int winningCount;
    int bonusCount;
    int prizeMoney;
    int totalCount;


    WinningPrize(int winningCount, int bonusCount, int prizeMoney,int totalCount) {
        this.winningCount = winningCount;
        this.bonusCount = bonusCount;
        this.totalCount = totalCount;
        this.prizeMoney = prizeMoney;
    }

    public void setTotalCount() {
        totalCount += 1;

    }

    public void getTotalMessage() {
        System.out.println(winningCount+"개 일치 " +"(%) - "+totalCount + "개");
    }

}
