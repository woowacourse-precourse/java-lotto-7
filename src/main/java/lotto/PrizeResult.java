package lotto;

public class PrizeResult {
    private static final String RATE_OF_RETURN_ROUND = "%.1f";

    int totalPrizeMoney = 0;

    public void makeTotalPrizeMoney(){
        for (WinningPrize prize:WinningPrize.values()) {
            totalPrizeMoney += prize.getPrizeMoney();
        }
    }

    public String getRateOfReturn(int money) {
        makeTotalPrizeMoney();
        return makeRateOfReturn((totalPrizeMoney  / (money*1.0))*100);
    }

    private String makeRateOfReturn(double rateOfMoney) {
        return String.format(RATE_OF_RETURN_ROUND,rateOfMoney);
    }
}
