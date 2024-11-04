package lotto;

import java.util.ArrayList;
import lotto.controller.Draw;
import lotto.domain.Lotto;
import lotto.domain.Store;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        int amount = InputView.getAmount();
        ArrayList<Lotto> tickets = Store.ticketMachine(amount);
        OutputView.printTickets(tickets, amount);

        Lotto winningNumber = InputView.getWinningNumber();
        int bonus = InputView.getBonus(winningNumber);

        Draw draw = new Draw(amount, tickets, winningNumber, bonus);
        draw.run();
    }
}
