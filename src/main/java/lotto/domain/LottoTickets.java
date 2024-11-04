package lotto.domain;

import java.util.List;
import java.util.Set;

public class LottoTickets {
    private final List<Lotto> tickets;

    private LottoTickets(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public static LottoTickets of(List<Lotto> tickets) {
        return new LottoTickets(tickets);
    }

    public int getCount() {
        return tickets.size();
    }

    public List<String> getLottoNumbers() {
        return tickets.stream()
                .map(Object::toString)
                .toList();
    }

    public WinningStatistics getWinningStatistics(Set<Integer> winningNumbers, int bonusNumber) {
        WinningStatistics winningStatistics = WinningStatistics.init();
        tickets.forEach(lotto -> {
            Rank rank = lotto.getResult(winningNumbers, bonusNumber);
            winningStatistics.saveWinningResult(rank);
        });
        return winningStatistics;
    }

}
