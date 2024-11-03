package lotto.util;

public class WinningResult {
    private int match3Count;
    private int match4Count;
    private int match5Count
    private int match5AndBonusCount;
    private int match6Count;

    public WinningResult(){
        this.match3Count = 0;
        this.match4Count = 0;
        this.match5Count = 0;
        this.match5AndBonusCount = 0;
        this.match6Count = 0;
    }



    public long getTotalPrice(){
        int totalPrice = 0;
        totalPrice += 5000*match3Count;
        totalPrice += 50_000*match4Count;
        totalPrice += 1_500_000*match5Count;
        totalPrice += 30_000_000*match5AndBonusCount;
        totalPrice += 2_000_000_000*match6Count;
        return totalPrice;
    }
}
