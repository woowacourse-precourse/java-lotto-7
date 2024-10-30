package lotto.domain;

import static lotto.utils.Constant.MIN_PURCHASE_AMOUNT;

public class LottoManager {

    public void generateLottoNumbers(int purchaseAmount) {
        int lottoCount = purchaseAmount / MIN_PURCHASE_AMOUNT;
    }
}
