package lotto;

import lotto.io.InputReader;
import lotto.io.Viewer;
import lotto.lotto.value.Lotto;
import lotto.lotto.value.Money;
import lotto.lotto.value.Prize;
import lotto.lotto.value.WinningNumber;

import java.util.List;

public class Controller {

    private final LottoService lottoService;

    public Controller(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void start() {
        List<Lotto> tickets = buyTickets();
        compareNumbers(tickets);
    }

    private void compareNumbers(List<Lotto> tickets) {
        Viewer.enterWinningNumbers();
        WinningNumber winningNumber = InputReader.readWinningNumber();

        Viewer.enterBonusNumbers();
        int bonusNumber = InputReader.readBonus();
        String result = lottoService.compareAndGetResult(tickets, winningNumber, bonusNumber);

        Viewer.showResult(result);
    }

    private List<Lotto> buyTickets() {
        Viewer.enterMoneyMessage();

        Money money = InputReader.readMoney();
        List<Lotto> tickets = lottoService.buyLotto(money);

        Viewer.showSoldTickets(tickets);
        return tickets;
    }
}
