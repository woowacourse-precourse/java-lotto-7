package lotto.service;

import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;

public interface LottoService {
    LottoTicket generateLottoTicket(String purchaseAmountInput);
    WinningLotto createWinningLotto(String winningNumbersInput, String bonusNumberInput);
}
