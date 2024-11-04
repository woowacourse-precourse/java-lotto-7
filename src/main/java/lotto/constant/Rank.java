package lotto.constant;

public enum Rank {
    LOSE0(0,"0",0,false),
    LOSE1(1,"0",0,false),
    LOSE2(2,"0",0,false),
    FIFTH(3,"5,000",5000,false),
    FIRTH(4,"50,000",50000,false),
    THIRD(5,"1,500,000",1500000,false),
    SECOND(5,"30,000,000",30000000,true),
    FIRST(6,"2,000,000,000",2000000000,false);


    private final int correctNumber;
    private final String winningPrizeString;
    private final int winningPrize;
    private final boolean bonusNumberCheck;


    Rank(int correctNumber, String winningPrizeString,int winningPrize ,boolean bonusNumberCheck) {
        this.correctNumber = correctNumber;
        this.winningPrizeString = winningPrizeString;
        this.winningPrize=winningPrize;
        this.bonusNumberCheck = bonusNumberCheck;
    }

    public int correctNumber() {
        return correctNumber;
    }

    public String winningPrizeString() {
        return winningPrizeString;
    }

    public int winningPrize() {
        return winningPrize;
    }

    public boolean bonusNumberCheck() {
        return bonusNumberCheck;
    }
}
