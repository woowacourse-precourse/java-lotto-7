package lotto;

import java.util.List;
import lotto.domain.Ticket;
import lotto.io.Input;
import lotto.io.Output;
import lotto.service.TicketService;

public class Application {
    public static void main(String[] args) {
        int price = Input.price();
        List<Integer> winningNumbers = Input.winningNumbers();
        int bonusNumber = Input.bonusNumber();

        Ticket ticket = TicketService.generateTicket(price, winningNumbers, bonusNumber);
        Output.lottos(ticket);
        Output.result(ticket);
    }
}
