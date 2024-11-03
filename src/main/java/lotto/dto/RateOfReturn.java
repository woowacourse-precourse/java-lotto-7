package lotto.dto;

public record RateOfReturn(
        double rate
) {
    public static RateOfReturn of(long totalReword, int lottoPurchaseCost) {
        return new RateOfReturn(((double) totalReword / lottoPurchaseCost) * 100);
    }
}
