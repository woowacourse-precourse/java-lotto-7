package lotto.lotto.winning.domain;

import lotto.money.domain.Money;
import lotto.lotto.domain.LottoTickets;
import lotto.money.infrastructure.WinningAmount;

public class WinningAmountCalculator {
    public Benefit updateBenefit(LottoTickets lottoTickets, WinningLotto winningLotto, BonusNumber bonusNumber) {
        Money winningAmount = winningCalculate(lottoTickets, winningLotto, bonusNumber);
        return new Benefit(winningAmount);
    }
    private Money winningCalculate(LottoTickets lottoTickets, WinningLotto winningLotto, BonusNumber bonusNumber) {
        return new WinningAmount(lottoTickets.info().stream()
                .map((lotto) -> WinningPlace.calculate(winningLotto, bonusNumber, lotto))
                .mapToLong(Money::getMoney)
                .sum());
    }
}
