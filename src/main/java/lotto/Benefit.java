package lotto;

public class Benefit {
    private static final int[] PRIZES = {0, 2000000000, 30000000, 1500000, 50000, 5000};

    public double calculateBenefit(int purchaseAmount, int[] ranks){
        int totalPrize = 0;
        for(int i = 1;i<ranks.length;i++){
            totalPrize += ranks[i]*PRIZES[i];
        }
        return (double) totalPrize/purchaseAmount*100;
    }

}
