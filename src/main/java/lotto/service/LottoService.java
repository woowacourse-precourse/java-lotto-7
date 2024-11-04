package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;

public interface LottoService {
    LottoTicket generateLottoTicket(String purchaseAmountInput);
    WinningLotto createWinningLotto(Lotto winningNumbers, int bonusNumber);
    Lotto parseAndValidateWinningNumbers(String winningNumbersInput);
    int parseAndValidateBonusNumber(String bonusNumberInput, Lotto winningNumbers);
    LottoResult createLottoResult(LottoTicket lottoTicket, WinningLotto winningLotto, String purchaseAmount);
}
