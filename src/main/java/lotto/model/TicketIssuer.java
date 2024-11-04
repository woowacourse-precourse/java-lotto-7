package lotto.model;

import java.util.List;

public interface TicketIssuer {

    List<Ticket> issue(final int purchaseAmount);

    void validatePurchaseAmount(final int purchaseAmount);

    int getTicketCount();
}
