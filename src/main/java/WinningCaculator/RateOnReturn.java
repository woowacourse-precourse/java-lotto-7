package WinningCaculator;

public class RateOnReturn {
    int firstPrize = 2000000000;
    int secondPrize = 30000000;
    int thirdPrize = 1500000;
    int fourPrize = 50000;
    int fivePrize = 5000;

    public void RateOnReturnCalculation(int five,int four,int third,int second,int first,int buyLottoAmount) {
        int totalPrize = (first * firstPrize)
                + (second * secondPrize)
                + (third * thirdPrize)
                + (four * fourPrize)
                + (five * fivePrize);

        double profitRate = ((double) totalPrize / buyLottoAmount);
        profitRate = Math.round(profitRate * 10) / 100.0; // 소수점 첫째 자리 반올림

        System.out.println("총 수익률은 " + profitRate + "%" +  "입니다.");
    }
}
