package lotto.lotto.service;

import lotto.lotto.domain.BonusNumber;
import lotto.lotto.domain.LottoTickets;
import lotto.lotto.domain.WinningLotto;

public interface LottoGenerator {
    LottoTickets lottoTickets(int count);
    BonusNumber bonusNumber(WinningLotto winningLotto);
    WinningLotto winningLotto();
}
