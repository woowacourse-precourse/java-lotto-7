package lotto.validator;

import lotto.constants.LottoConstants;

public class PurchaseAmountValidator {

    public boolean isValidPurchaseAmount(String inputAmount) {
        int purchaseAmount = 0;
        try {
            purchaseAmount = Integer.parseInt(inputAmount);
            if (purchaseAmount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력이 잘못되었습니다. 숫자로만 입력해 주세요.");
        }
        return purchaseAmount % LottoConstants.PURCHASE_UNIT == 0;
    }
}
