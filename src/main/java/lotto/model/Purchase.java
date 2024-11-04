package lotto.model;

import lotto.dto.PurchaseAmountDto;

import static lotto.properties.LottoProperties.LOTTO_PRICE;

public class Purchase {

    private final int purchaseAmount;
    private final int purchaseLottoCount;

    public Purchase(int purchaseAmount, int purchaseLottoCount) {
        this.purchaseAmount = purchaseAmount;
        this.purchaseLottoCount = purchaseLottoCount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getPurchaseLottoCount() {
        return purchaseLottoCount;
    }

    public static Purchase from(PurchaseAmountDto dto) {
        return new Purchase(
                dto.purchaseAmount(),
                dto.purchaseAmount() / LOTTO_PRICE);
    }
}
