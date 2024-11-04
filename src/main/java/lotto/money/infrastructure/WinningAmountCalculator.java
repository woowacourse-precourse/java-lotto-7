package lotto.money.infrastructure;

import lotto.lotto.domain.BonusNumber;
import lotto.lotto.domain.WinningLotto;
import lotto.money.domain.WinningPlace;
import lotto.money.domain.Money;
import lotto.lotto.domain.LottoTickets;

public class WinningAmountCalculator {
    public Money calculate(LottoTickets lottoTickets, WinningLotto winningLotto, BonusNumber bonusNumber) {
        return new WinningAmount(lottoTickets.info().stream()
                .map((lotto) -> WinningPlace.calculate(winningLotto, bonusNumber, lotto))
                .mapToLong(Money::getMoney)
                .sum());
    }
}
