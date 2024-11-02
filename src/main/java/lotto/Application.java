package lotto;

import lotto.domain.Machine;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        int money = inputView.getMoney();

        Machine machine = new Machine(money);
        outputView.showTicket(machine);

        WinningNumbers winningNumbers = inputView.getWinningNumbers();
        outputView.showResult(machine, winningNumbers);
    }
}