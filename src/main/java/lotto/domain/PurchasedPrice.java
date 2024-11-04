package lotto.domain;

import static lotto.domain.LottoConstants.LOTTO_PRICE;

public class PurchasedPrice {
    private int purchasedPrice;

    public PurchasedPrice(int purchasedPrice) {
        validatePurchasedPrice(purchasedPrice);
        this.purchasedPrice = purchasedPrice;
    }

    public static void validateNotNull(PurchasedPrice purchasedPrice) {
        if(purchasedPrice == null) {
            throw new IllegalStateException("[ERROR] 구매 금액이 제대로 저장되지 않았습니다.");
        }
    }

    private void validatePurchasedPrice(int purchasedPrice) {
        if(purchasedPrice % LOTTO_PRICE != 0){
            throw new IllegalArgumentException("[ERROR] 로또 한 장은 1000원입니다. 1000의 배수를 입력해주세요.");
        }
    }

    public int getPurchasedPrice() {
        return purchasedPrice;
    }
}
