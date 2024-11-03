package ticket;

import java.util.List;

public interface TicketIssuer {
    List<Ticket> issue(final int purchaseAmount);
}
