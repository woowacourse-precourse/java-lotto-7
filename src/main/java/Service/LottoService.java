package Service;

import lotto.PurchaseCount;

public class LottoService {
    public PurchaseCount getCount(String purchaseAmountFromView) {
        int purchaseAmount = purchaseAmountValidate(purchaseAmountFromView);
        return new PurchaseCount(purchaseAmount);
    }

    private int purchaseAmountValidate(String purchaseAmountFromView) {
        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(purchaseAmountFromView);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력해야 합니다.");
        }
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000 이상이어야 합니다.");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
        }
        return purchaseAmount;
    }
}
