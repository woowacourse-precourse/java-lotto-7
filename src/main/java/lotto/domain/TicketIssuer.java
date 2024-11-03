package lotto.domain;

import lotto.dto.IssuedTickets;
import lotto.dto.TicketCount;
import lotto.dto.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

public class TicketIssuer {

    private final TicketCount ticketCount;

    public TicketIssuer(TicketCount ticketCount) {
        this.ticketCount = ticketCount;
    }

    public IssuedTickets issueTickets() {
        List<WinningNumbers> issuedTickets = new ArrayList<>();

        for (int i = 0; i < ticketCount.count(); i++) {
            WinningNumbersGenerator winningNumbersGenerator = new WinningNumbersGenerator();
            WinningNumbers winningNumbers = winningNumbersGenerator.generate();
            issuedTickets.add(winningNumbers);
        }

        return new IssuedTickets(issuedTickets);
    }
}
