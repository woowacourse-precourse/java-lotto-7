package lotto.service;

import lotto.constants.OutputViewConstants;

import java.util.List;

public class OutputService {
    public void showPurchaseAmount(int purchaseAmount) {
        System.out.println(purchaseAmount + OutputViewConstants.PURCHASE_AMOUNT_DESCRIPTION);
    }

    public void showGeneratedLottoNumbers(List<List<Integer>> generatedLottoNumbers) {
        for (List<Integer> generatedLottoNumber : generatedLottoNumbers) {
            System.out.println(generatedLottoNumber);
        }
    }
}
