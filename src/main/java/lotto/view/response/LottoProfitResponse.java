package lotto.view.response;

public class LottoProfitResponse {

    private final double profitRate;

    private LottoProfitResponse(double profitRate) {
        this.profitRate = profitRate;
    }

    public static LottoProfitResponse from(double profitRate) {
        return new LottoProfitResponse(profitRate);
    }

    public double getProfitRate() {
        return profitRate;
    }
}
