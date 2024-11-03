package lotto.service;

import java.util.List;
import lotto.model.Ticket;

public interface TicketGenerator {

    void setMoney(long money);

    List<Ticket> getTickets();

    Ticket getTicket();
}
