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

    public int getRank() {
        if (this.count == 6){
            this.rank = 1;
        }
        else if (this.count == 5 && this.bonusCount == 1){
            this.rank = 2;
        }
        else if (this.count == 5){
            this.rank = 3;
        }
        else if (this.count == 4){
            this.rank = 4;
        }
        else if (this.count == 3){
            this.rank = 5;
        }
        else this.rank = 6;
        return this.rank;
    }

    public int getPrize(){
        Prize prize = new Prize();
        return prize.getOfPrizeAmount(rank);
    }
}
