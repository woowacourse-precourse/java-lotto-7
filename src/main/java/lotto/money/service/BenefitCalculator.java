package lotto.money.service;

import lotto.lotto.domain.LottoTickets;
import lotto.lotto.domain.BonusNumber;
import lotto.lotto.domain.WinningLotto;
import lotto.money.domain.Benefit;

public interface BenefitCalculator {
    Benefit create(LottoTickets lottoTickets, WinningLotto winningLotto, BonusNumber bonusNumber);

}
