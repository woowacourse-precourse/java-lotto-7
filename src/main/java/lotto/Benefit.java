package lotto;

public class Benefit {
    private static final int[] PRIZES = {2000000000, 30000000, 1500000, 50000, 5000, 0};

    public double calculateBenefit(int purchaseAmount, int[] ranks){
        int totalPrize = calculateTotalPrize(ranks);
        double benefit = (double) totalPrize / purchaseAmount*100;
        return Math.round(benefit*10)/10.0;
    }

    private int calculateTotalPrize(int[] ranks) {
        int totalPrize = 0;
        for(int i = 0;i<ranks.length;i++){
            totalPrize +=ranks[i]*PRIZES[i];
        }
        return totalPrize;
    }

}
