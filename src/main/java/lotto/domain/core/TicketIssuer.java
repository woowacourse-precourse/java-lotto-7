package lotto.domain.core;

import lotto.domain.generator.WinningNumbersGenerator;
import lotto.dto.result.IssuedTickets;
import lotto.dto.result.TicketCount;
import lotto.dto.result.WinningNumbers;

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
