package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketBundle {
    private final List<Lotto> tickets;

    private LottoTicketBundle(List<Lotto> tickets) {
        this.tickets = List.copyOf(tickets);
    }

    public static LottoTicketBundle from(LottoGenerateStrategy strategy, int count) {
        List<Lotto> tickets = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(strategy.pickNumbers()))
                .toList();
        return new LottoTicketBundle(tickets);
    }

    public List<Prize> getPrizes(WinningTicket winningCombination) {
        return tickets.stream()
                .map(ticket -> ticket.match(winningCombination))
                .filter(prize -> prize != Prize.NONE)
                .toList();
    }

    public int getTotalReward(WinningTicket winningTicket) {
        return getPrizes(winningTicket).stream()
                .mapToInt(Prize::getReward)
                .sum();
    }

    @Override
    public String toString() {
        return tickets.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public int size() {
        return tickets.size();
    }
}
