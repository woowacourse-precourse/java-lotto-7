package lotto;

public class LottoPaper {
    private static final Won BASE_AMOUNT = new Won(1000);

    public LottoPaper(Won fee) {
        validateMinimumAmount(fee);
        validateAmountIsInBaseUnit(fee);
    }

    private void validateMinimumAmount(Won won) {
        if (BASE_AMOUNT.isLessThan(won)) {
            throw new IllegalArgumentException(String.format("금액이 %s보다 낮을 수 없습니다.", BASE_AMOUNT));
        }
    }

    private void validateAmountIsInBaseUnit(Won fee) {
        if (fee.hasChange(BASE_AMOUNT)) {
            throw new IllegalArgumentException(String.format("금액은 %s단위 여야합니다.", BASE_AMOUNT));
        }
    }
}
