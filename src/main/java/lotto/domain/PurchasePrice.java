package lotto.domain;

import lotto.view.ErrorMessage;

public class PurchasePrice {
    public static final int LOTTO_PRICE = 1000;
    private final int purchasePrice;

    // 생성자 - inputview에서 넘어옴
    public PurchasePrice(int inputPrice) {
        validatePurchaseAmount(inputPrice);
        this.purchasePrice = inputPrice;
    }

    // 구매한 금액 가져오기
    public int getPurchasePrice() {
        return purchasePrice;
    }

    // 천 단위인지 확인
    private void validatePurchaseAmount(int inputPrice) {
        if (inputPrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_UNIT_OF_1000.getMessage());
        }
    }
}
