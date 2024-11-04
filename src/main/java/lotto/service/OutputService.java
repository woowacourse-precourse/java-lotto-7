package lotto.service;

import lotto.domain.Lotto;
import lotto.constants.OutputViewConstants;

import java.util.List;

public class OutputService {
    public void showPurchaseAmount(int purchaseAmount) {
        System.out.println(purchaseAmount + OutputViewConstants.PURCHASE_AMOUNT_DESCRIPTION);
    }

    public void showGeneratedLottoNumbers(List<Lotto> generatedLotto) {
        for (Lotto lotto : generatedLotto) {
            System.out.println(lotto.getNumbers());
        }
    }
}
