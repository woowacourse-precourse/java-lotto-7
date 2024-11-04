package lotto.model;

public class SingleResult {
    private int count;
    private int bonusCount;
    private int rank;

    public SingleResult(){
        this.count = 0;
        this.bonusCount = 0;
        this.rank = 0;
    }

    public void countUp() {this.count++;}
    public void bonusCountUp() {this.bonusCount++;}

    private void calculateRank(){
        this.rank = 6;
        if (this.count == 6) this.rank = 1;
        if (this.count == 5 && this.bonusCount == 1) this.rank = 2;
        if (this.count == 5) this.rank = 3;
        if (this.count == 4) this.rank = 4;
        if (this.count == 3) this.rank = 5;
    }

    public int getRank() {
        calculateRank();
        return this.rank;
    }

    public int getPrize(){
        Prize prize = new Prize();
        return prize.getOfPrizeAmount(rank);
    }
}
