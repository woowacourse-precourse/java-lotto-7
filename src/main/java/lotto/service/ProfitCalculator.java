package lotto.service;

public class ProfitCalculator {
    public static double calculateProfitRate(int totalSpent, int totalPrize){
        if(totalSpent == 0)return 0.0;
        double profitRate = ((double) totalPrize/totalSpent) * 100;
        return Math.round(profitRate*10)/10.0;
    }
    public void printProfitRate(int totalSpent, int totalPrize){
        System.out.println("총 수익률은 "
                +calculateProfitRate(totalSpent, totalPrize)+"%입니다.");
    }
}
