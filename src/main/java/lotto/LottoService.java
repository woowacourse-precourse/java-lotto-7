package lotto;

import lotto.lotto.*;
import lotto.lotto.value.Lotto;
import lotto.lotto.value.Money;
import lotto.lotto.value.Prize;
import lotto.lotto.value.WinningNumber;

import java.util.List;

public class LottoService {

    private final Cashier cashier;

    public LottoService(Cashier cashier) {
        this.cashier = cashier;
    }

    public List<Lotto> buyLotto(Money money) {
        return cashier.sellLotto(money);
    }

    public String compareAndGetResult(List<Lotto> tickets, WinningNumber winningNumber, int bonusNumber) {
        Announcer announcer = new Announcer(winningNumber, bonusNumber);
        List<Prize> prizes = announcer.compareLottoResult(tickets);

        Analyst analyst = new Analyst(prizes);
        return analyst.announceResult(cashier.getIncome());
    }
}
