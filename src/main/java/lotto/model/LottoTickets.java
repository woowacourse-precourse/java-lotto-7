package lotto.model;

import java.util.List;

public record LottoTickets(List<LottoTicket> tickets, Money totalPrice) {

    public LottoTickets(List<LottoTicket> tickets) {

        this(tickets, calculateTotalPrice(tickets));
    }

    private static Money calculateTotalPrice(List<LottoTicket> tickets) {
        return tickets.stream()
                .map(LottoTicket::price)
                .reduce(Money.of(0), Money::plus);
    }

    public boolean isEmpty() {
        return tickets.isEmpty();
    }

    @Override
    public String toString() {
        return tickets.stream()
                .map(LottoTicket::toString)
                .reduce((a, b) -> a + "\n" + b)
                .orElse("");
    }
}
