package lotto.service;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;

public interface LottoService {
    LottoTicket generateLottoTicket(String purchaseAmountInput);
    WinningLotto createWinningLotto(String winningNumbersInput, String bonusNumberInput);
    LottoResult createLottoResult(LottoTicket lottoTicket, WinningLotto winningLotto);
}
