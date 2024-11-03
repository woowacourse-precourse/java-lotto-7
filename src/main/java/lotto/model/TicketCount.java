package lotto.model;

import java.util.Objects;

public class TicketCount {

    private static final int ONE_TICKET_PRICE = 1000;

    private final int ticketCount;

    public TicketCount(InputAmount amount) {
        this.ticketCount = amount.get() / ONE_TICKET_PRICE;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TicketCount comparingTicketCount = (TicketCount) obj;
        return Objects.equals(ticketCount, comparingTicketCount.ticketCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketCount);
    }

    public int get() {
        return ticketCount;
    }
}
