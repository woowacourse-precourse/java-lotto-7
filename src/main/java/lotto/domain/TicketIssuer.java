package lotto.domain;

import static lotto.exception.ErrorMessage.*;

import lotto.dto.IssuedTickets;
import lotto.dto.TicketCount;
import lotto.dto.WinningNumbers;
import lotto.exception.CustomIllegalArgumentException;

import java.util.ArrayList;
import java.util.List;

public class TicketIssuer {

    private final TicketCount ticketCount;
    private final WinningNumbersGenerator winningNumbersGenerator;

    public TicketIssuer(TicketCount ticketCount, WinningNumbersGenerator winningNumbersGenerator) {
        validate(winningNumbersGenerator);
        this.ticketCount = ticketCount;
        this.winningNumbersGenerator = winningNumbersGenerator;
    }

    public IssuedTickets issueTickets() {
        List<WinningNumbers> issuedTickets = new ArrayList<>();

        for (int i = 0; i < ticketCount.count(); i++) {
            WinningNumbers winningNumbers = winningNumbersGenerator.generate();
            issuedTickets.add(winningNumbers);
        }

        return new IssuedTickets(issuedTickets);
    }

    private void validate(WinningNumbersGenerator winningNumbersGenerator) {
        if (winningNumbersGenerator == null) {
            throw CustomIllegalArgumentException.from(WINNING_NUMBERS_GENERATOR_NULL);
        }
    }
}