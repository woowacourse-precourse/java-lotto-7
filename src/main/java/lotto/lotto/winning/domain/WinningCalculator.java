package lotto.lotto.winning.domain;

import lotto.buyer.domain.Money;
import lotto.buyer.infrastructure.Won;
import lotto.lotto.domain.LottoTickets;

public class WinningCalculator {
    private final Money money;
    public WinningCalculator(Money money) {
        this.money = money;
    }
    public Benefit updateBenefit(LottoTickets lottoTickets, WinningLotto winningLotto, BonusNumber bonusNumber) {
        Money benefitMoney = winningCalculate(lottoTickets, winningLotto, bonusNumber);
        money.updateMoney(benefitMoney);
        return new Benefit(money);
    }
    private Money winningCalculate(LottoTickets lottoTickets, WinningLotto winningLotto, BonusNumber bonusNumber) {
        return Won.of(lottoTickets.info().stream()
                .map((lotto) -> WinningPlace.calculate(winningLotto, bonusNumber, lotto))
                .mapToLong(Money::getMoney)
                .sum());
    }
}
