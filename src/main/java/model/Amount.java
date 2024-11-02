package model;


public class Amount {

    private final int purchaseAmount;
    private static final int lottoValue = 1000;
    private static final String DIVIDE_LOTTO_VALUE_ERROR = "[ERROR] 로또 가격으로 나누어 떨어지지 않습니다.";

    public Amount(int purchaseAmount) {
        divideByLottoValue(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private void divideByLottoValue(int purchaseAmount) {
        if (purchaseAmount % lottoValue != 0) {
            throw new IllegalArgumentException(DIVIDE_LOTTO_VALUE_ERROR);
        }
    }
}
