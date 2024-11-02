package lotto.controller;
import lotto.exceptions.LottoNumberRangeException;
import lotto.exceptions.LottoPriceUnder1000Exception;

public class LottoValidator {
    public void isValidAmount(int purchaseAmount) {
        if(purchaseAmount < 1000) {
            throw new LottoPriceUnder1000Exception();
        }
        if(purchaseAmount % 1000 != 0) {
            throw new LottoPriceUnder1000Exception();
        }
    }

    public void isValidBonusNumber(int bonusNumber) {
        if(bonusNumber < 1 || bonusNumber > 45) {
            throw new LottoNumberRangeException();
        }
    }
}
