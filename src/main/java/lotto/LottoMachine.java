package lotto;


public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 6;

    public int calculateLottoCount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_AMOUNT.getErrorMessage());
        }
        return purchaseAmount / LOTTO_PRICE;
    }
}
