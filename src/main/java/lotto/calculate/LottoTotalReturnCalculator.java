package lotto.calculate;

public class LottoTotalReturnCalculator {
    private static final double NEED_TO_BE_MULTIPLIED_TO_INDEICATE_PERCENTAGE = 100.0;
    private static final String TOTAL_RETURN_RATE_PREFIX = "총 수익률은 ";
    private static final String TOTAL_RETURN_RATE_SUFFIX = "입니다.";
    private static final String PERCENTAGE_SYMBOL = "%";

    private final long totalWinningAmount;
    private final int lottoPurchaseAmount;

    public LottoTotalReturnCalculator(long totalWinningAmount, int lottoPurchaseAmount) {
        this.totalWinningAmount = totalWinningAmount;
        this.lottoPurchaseAmount = lottoPurchaseAmount;
    }

    public String run() {
        double totalReturn = (double) totalWinningAmount / lottoPurchaseAmount * NEED_TO_BE_MULTIPLIED_TO_INDEICATE_PERCENTAGE;
        String roundedSecondDecimalPlaceReturn = String.format("%,.1f", totalReturn);

        System.out.println(TOTAL_RETURN_RATE_PREFIX + roundedSecondDecimalPlaceReturn + PERCENTAGE_SYMBOL + TOTAL_RETURN_RATE_SUFFIX);

        return roundedSecondDecimalPlaceReturn;
    }
}
