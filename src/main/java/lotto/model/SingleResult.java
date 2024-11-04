package lotto.model;

public class SingleResult {
    private int count;
    private int bonusCount;
    private int prize;

    public SingleResult() {
        this.count = 0;
        this.bonusCount = 0;
        this.prize = 0;
    }

    public void countUp() { this.count++; }
    public void bonusCountUp() { this.bonusCount++; }

    public int getRank(){
        return Prize.getIndex(this.prize);
    }

    public int getPrize() {
        this.prize = Prize.calculatePrize(count, bonusCount);
        return prize;
    }
}
