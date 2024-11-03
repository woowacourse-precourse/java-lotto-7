package lotto.service;

import lotto.domain.calculator.TicketCountCalculator;
import lotto.domain.core.PurchaseTotalPrice;
import lotto.domain.core.TicketIssuer;
import lotto.dto.result.FormattedTickets;
import lotto.dto.result.IssuedTickets;
import lotto.dto.result.SortedIssuedTickets;
import lotto.dto.result.TicketCount;
import lotto.utils.formatter.TicketFormatter;
import lotto.utils.sorter.TicketSorter;
import lotto.view.OutputView;

public class TicketService {
    private final OutputView outputView;

    public TicketService(OutputView outputView) {
        this.outputView = outputView;
    }

    public IssuedTickets issueTickets(PurchaseTotalPrice purchaseTotalPrice) {
        TicketCount ticketCount = calculateTicketCount(purchaseTotalPrice);
        outputView.printPurchasedTicketCount(ticketCount.count());

        IssuedTickets issuedTickets = createIssuedTickets(ticketCount);

        SortedIssuedTickets sortedTickets = sortTickets(issuedTickets);
        printFormattedTickets(sortedTickets);

        return issuedTickets;
    }

    private TicketCount calculateTicketCount(PurchaseTotalPrice purchaseTotalPrice) {
        TicketCountCalculator calculator = new TicketCountCalculator();
        return calculator.calculateTotalTicketCount(purchaseTotalPrice);
    }

    private IssuedTickets createIssuedTickets(TicketCount ticketCount) {
        TicketIssuer issuer = new TicketIssuer(ticketCount);
        return issuer.issueTickets();
    }

    private SortedIssuedTickets sortTickets(IssuedTickets issuedTickets) {
        return TicketSorter.getSortedTickets(issuedTickets);
    }

    private void printFormattedTickets(SortedIssuedTickets sortedTickets) {
        FormattedTickets formattedTickets = TicketFormatter.formatTickets(sortedTickets);
        outputView.printFormattedTickets(formattedTickets);
    }
}
