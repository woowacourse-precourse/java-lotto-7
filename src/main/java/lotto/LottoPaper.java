package lotto;

public class LottoPaper {
    private static final Won BASE_AMOUNT = new Won(1000);

    public LottoPaper(Won won) {
        validateMinimumAmount(won);
    }

    private void validateMinimumAmount(Won won) {
        if (BASE_AMOUNT.isLessThan(won)) {
            throw new IllegalArgumentException(String.format("금액이 %s보다 낮을 수 없습니다.", BASE_AMOUNT));
        }
    }
}
