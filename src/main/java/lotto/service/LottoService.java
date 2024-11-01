package lotto.service;

import java.util.List;
import lotto.model.LottoStore;
import lotto.model.LottoTicket;
import lotto.model.WinningLotto;
import lotto.util.Validator;

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
        Validator.isNotInList(winningLotto.getNumbers(), Integer.parseInt(bonusNumber));
    }
}
