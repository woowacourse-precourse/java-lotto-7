package lotto.view.output.domain;

import lotto.buyer.domain.Money;
import lotto.lotto.winning.domain.Benefit;
import lotto.lotto.winning.domain.BonusNumber;
import lotto.lotto.domain.LottoTickets;
import lotto.lotto.winning.domain.WinningLotto;

public interface ResultViewService {
    void viewByInsertMoney(Money money);

    void viewByLottoTickets(LottoTickets lottoTickets);

    void viewByWinningLotto(WinningLotto winningLotto);

    void viewByBonusNumber(BonusNumber bonusNumber);

    void viewByWinningStatistic(Benefit benefit, Money purchaseMoney);
}
