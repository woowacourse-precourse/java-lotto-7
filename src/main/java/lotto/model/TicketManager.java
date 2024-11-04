package lotto.model;

import lotto.vo.Payment;
import lotto.vo.Ticket;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.common.Constants.*;

public class TicketManager {
    private final Payment payment;
    private final int ticketAmount;
    private final List<Ticket> tickets;

    public TicketManager(Payment payment) {
        this.payment = payment;
        this.ticketAmount = takeTicketAmount(payment);
        this.tickets = issueTickets(ticketAmount);
    }

    private int takeTicketAmount(Payment payment) {
        int money = payment.getMoney();
        return money / UNIT;
    }

    private List<Ticket> issueTickets(int ticketAmount) {
        return IntStream.range(START_INDEX, ticketAmount)
                .mapToObj(amount -> new Ticket())
                .collect(Collectors.toList());
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
