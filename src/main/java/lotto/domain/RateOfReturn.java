package lotto.domain;

public class RateOfReturn {
    private static final int THREE = 5000;
    private static final int FOUR = 50000;
    private static final int FIVE = 1500000;
    private static final int FIVE_AND_BONUS = 30000000;
    private static final int SIX = 2000000000;

    public RateOfReturn(){
    }
    public double rate(int[] count,int purchaseAmount){
        int player_sum=playerSum(count);
        double winRate = ((double) player_sum / purchaseAmount) * 100;
        return winRate;
    }
    public int playerSum(int[] count){
        int[] amount={THREE,FOUR,FIVE,SIX,FIVE_AND_BONUS};
        int num=0;
        int sum=0;
        for(int i=3;i<count.length;i++){
            sum+=amount[num]*count[i];
            num++;
        }
        return sum;
    }
}
