package lotto.lotto.domain;

import lotto.lotto.winning.domain.BonusNumber;
import lotto.lotto.winning.domain.WinningLotto;

public interface LottoCreatorService {
    LottoTickets createLottoTickets(int count);
    BonusNumber createBonusNumber(WinningLotto winningLotto);
    WinningLotto createWinningLotto();
}
