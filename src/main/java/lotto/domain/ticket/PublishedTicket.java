package lotto.domain.ticket;

public class PublishedTicket {

    private final Ticket ticket;

    private PublishedTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public PublishedTicket from(Ticket ticket) {
        return new PublishedTicket(ticket);
    }

    public Ticket getTicket() {
        return ticket;
    }

}
