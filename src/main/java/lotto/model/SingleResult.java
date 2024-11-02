package lotto.model;

public class SingleResult {
    private int count;
    private int bonusCount;
    private int rank;
    private int prize;
    
    public SingleResult(){
        this.count = 0;
        this.bonusCount = 0;
    }
    
    public int getCount(){
        return this.count;
    }
    public int getBonusCount(){
        return this.bonusCount;
    }
    public void countUp() {this.count++;}
    public void bonusCountUp() {this.bonusCount++;}
}
