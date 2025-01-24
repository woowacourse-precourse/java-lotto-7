package lotto.domain;

public class PrizeResult {
    private static final String RATE_OF_RETURN_ROUND = "%.1f";

    public String getRateOfReturn(int money, int totalMoney) {
        return makeRateOfReturn((totalMoney / (money * 1.0)) * 100);
    }

    private String makeRateOfReturn(double rateOfMoney) {
        return String.format(RATE_OF_RETURN_ROUND, rateOfMoney);
    }
}
