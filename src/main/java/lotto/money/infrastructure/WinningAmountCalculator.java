package lotto.money.infrastructure;

import lotto.lotto.winning.domain.BonusNumber;
import lotto.lotto.winning.domain.WinningLotto;
import lotto.lotto.winning.domain.WinningPlace;
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
