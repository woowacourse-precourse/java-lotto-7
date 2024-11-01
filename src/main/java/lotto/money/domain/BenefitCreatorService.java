package lotto.money.domain;

import lotto.lotto.domain.LottoTickets;
import lotto.lotto.winning.domain.BonusNumber;
import lotto.lotto.winning.domain.WinningLotto;

public interface BenefitCreatorService {
    Benefit create(LottoTickets lottoTickets, WinningLotto winningLotto, BonusNumber bonusNumber);

}
