package lotto.service;

import lotto.model.LottoStore;
import lotto.model.LottoTicket;
import lotto.model.WinningLotto;
import lotto.util.Validator;

import static lotto.model.LottoStore.LOTTO_NUMBER_MAXIMUM;
import static lotto.model.LottoStore.LOTTO_NUMBER_MINIMUM;

public class LottoService {

    public LottoTicket createLottoTicket(String purchaseMoney) {
        return LottoStore.makeLottoTicket(purchaseMoney);
    }

    public WinningLotto createWinningLotto(String winningNumber) {
        return WinningLotto.create(winningNumber);
    }

    public void addBonusNumber(WinningLotto winningLotto, String bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);
    }

    private void validateBonusNumber(WinningLotto winningLotto, String bonusNumber) {
        Validator.isEmptyInput(bonusNumber);
        Validator.isDigitString(bonusNumber);
        Validator.isInteger(bonusNumber);

        int bonusNumberInt = Integer.parseInt(bonusNumber);
        Validator.isNumberWithinRange(bonusNumberInt, LOTTO_NUMBER_MINIMUM, LOTTO_NUMBER_MAXIMUM);
        Validator.isNotInList(winningLotto.getNumbers(), bonusNumberInt);
    }
}
