package lotto.view.output.service;

import lotto.money.domain.Money;
import lotto.money.domain.Benefit;
import lotto.lotto.domain.BonusNumber;
import lotto.lotto.domain.LottoTickets;
import lotto.lotto.domain.WinningLotto;

public interface ResultViewService {
    void viewByInsertMoney(Money money);

    void viewByLottoTickets(LottoTickets lottoTickets);

    void viewByWinningLotto(WinningLotto winningLotto);

    void viewByBonusNumber(BonusNumber bonusNumber);

    void viewByWinningStatistic(Benefit benefit, Money purchaseMoney);
}
