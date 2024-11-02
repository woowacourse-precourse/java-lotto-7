package lotto.dto.response;

public record EarningRateResponse(
        double earningRate
) {
    public static EarningRateResponse from(double earningRate) {
        return new EarningRateResponse(earningRate);
    }
}
