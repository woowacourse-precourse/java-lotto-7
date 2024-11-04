package lotto;

import lotto.lotto.*;

import java.util.List;

public class LottoService {

    private final Cashier cashier;

    public LottoService(Cashier cashier) {
        this.cashier = cashier;
    }

    public List<Lotto> buyLotto(Money money) {
        return cashier.sellLotto(money);
    }

    public String compareNumbers(List<Lotto> tickets, WinningNumber winningNumber, int bonusNumber) {
        Announcer announcer = new Announcer(winningNumber, bonusNumber);
        List<Prize> prizes = announcer.compareLottoResult(tickets);
        Analyst analyst = new Analyst(prizes);

        return analyst.getStatistics();
    }
}
