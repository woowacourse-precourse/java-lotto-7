package lotto.service;

import lotto.domain.calculator.ProfitCalculator;
import lotto.domain.calculator.WinningCalculator;
import lotto.domain.money.Money;
import lotto.domain.result.WinningResult;
import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.Lottos;
import lotto.domain.ticket.WinningLotto;

public class LottoService {
    private final WinningCalculator winningCalculator;
    private final ProfitCalculator profitCalculator;

    public LottoService() {
        this.winningCalculator = new WinningCalculator();
        this.profitCalculator = new ProfitCalculator();
    }

    public Lottos purchaseLottos(int amount) {
        Money money = Money.from(amount);
        return Lottos.create(money.getLottoQuantity());
    }

    public WinningResult createWinningResult(Lottos lottos, WinningLotto winningLotto, int amount) {
        Money purchaseMoney = Money.from(amount);
        return calculateWinningResult(lottos, winningLotto, purchaseMoney);
    }

    private WinningResult calculateWinningResult(
            Lottos lottos,
            WinningLotto winningLotto,
            Money purchaseMoney) {
        return profitCalculator.calculateResult(
                winningCalculator.calculate(lottos, winningLotto),
                purchaseMoney
        );
    }
}