package lotto.money.infrastructure;

import lotto.lotto.domain.LottoTickets;
import lotto.lotto.domain.BonusNumber;
import lotto.lotto.domain.WinningLotto;
import lotto.money.domain.Benefit;
import lotto.money.domain.BenefitCalculator;
import lotto.money.domain.Money;

public class BenefitCreator implements BenefitCalculator {
    private final WinningAmountCalculator winningAmountCalculator;
    public BenefitCreator(WinningAmountCalculator winningAmountCalculator) {
        this.winningAmountCalculator = winningAmountCalculator;
    }
    @Override
    public Benefit create(LottoTickets lottoTickets, WinningLotto winningLotto, BonusNumber bonusNumber) {
        Money winningAmount = winningAmountCalculator.calculate(lottoTickets, winningLotto, bonusNumber);
        return new Benefit(winningAmount);
    }
}
