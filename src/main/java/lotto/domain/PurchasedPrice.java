package lotto.domain;

public class PurchasedPrice {
    private int purchasedPrice;

    public PurchasedPrice(int purchasedPrice) {
        validatePurchasedPrice(purchasedPrice);
        this.purchasedPrice = purchasedPrice;
    }

    private void validatePurchasedPrice(int purchasedPrice) {
        if(purchasedPrice % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또 한 장은 1000원입니다. 1000의 배수를 입력해주세요.");
        }
    }

    public int getPurchasedPrice() {
        return purchasedPrice;
    }
}
