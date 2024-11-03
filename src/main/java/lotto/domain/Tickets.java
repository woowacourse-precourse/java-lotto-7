package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lotto.utils.LottoNumbersGenerator;

public class Tickets {
    private final List<Ticket> tickets;

    public Tickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public static Tickets of(int count, LottoNumbersGenerator lottoNumbersGenerator) {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(Ticket.createByImplementation(lottoNumbersGenerator, true));
        }
        return new Tickets(tickets);
    }

    public List<Ticket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public Map<Rank, Integer> getResult(FirstTicket firstTicket) {
        List<Rank> ranks = getRanks(firstTicket);
        SortedMap<Rank, Integer> result = new TreeMap<>(Comparator.comparingInt(Rank::getAmount));

        for (Rank rank : ranks) {
            result.merge(rank, 1, (value, putValue) -> value + 1);
        }
        return Collections.unmodifiableMap(result);
    }

    private List<Rank> getRanks(FirstTicket firstTicket) {
        return tickets.stream()
                .map(firstTicket::getTicketRank)
                .collect(Collectors.toUnmodifiableList());
    }

    public double getYield(int amount, FirstTicket firstTicket) {
        List<Rank> ranks = getRanks(firstTicket);
        long totalAmount = ranks.stream()
                .mapToLong(Rank::getAmount)
                .sum();
        return Math.floor(((double) totalAmount / amount * 100)) / 100.0;
    }

    public int getTicketCount() {
        return tickets.size();
    }

    public void add(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public int getAutoTicketCount() {
        return (int) tickets.stream()
                .filter(Ticket::isAuto)
                .count();
    }

    public int getManualTicketCount() {
        return (int) tickets.stream()
                .filter(Predicate.not(Ticket::isAuto))
                .count();
    }

}
