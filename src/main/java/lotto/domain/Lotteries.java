package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.util.LottoNumberGenerator;
import lotto.global.common.Rank;

public class Lotteries {

    private final List<Lotto> lotteries;

    private Lotteries(final List<Lotto> lotto) {
        this.lotteries = lotto;
    }

    public static Lotteries of(final int count) {
        return new Lotteries(generateTicketList(count));
    }

    public List<Lotto> getLotteries() {
        return List.copyOf(lotteries);
    }

    public List<Rank> getTicketsResult(Lotto winningLotto, int bonus) {
        return lotteries.stream()
                .map(ticket -> ticket.check(winningLotto, bonus))
                .toList();
    }

    private static List<Lotto> generateTicketList(int count) {
        List<Lotto> ticketList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            ticketList.add(
                    new Lotto(LottoNumberGenerator.generateWinningNumbers()));
        }

        return ticketList;
    }

    public int size() {
        return lotteries.size();
    }

    @Override
    public String toString() {
        return lotteries.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
