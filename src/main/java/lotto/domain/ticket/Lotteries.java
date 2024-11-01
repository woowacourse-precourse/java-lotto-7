package lotto.domain.ticket;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.util.LottoNumberGenerator;
import lotto.global.common.Rank;

public class Lotteries {

    private final List<Lotto> lotto;

    private Lotteries(final List<Lotto> lotto) {
        this.lotto = lotto;
    }

    public static Lotteries of(final int count) {
        return new Lotteries(generateTicketList(count));
    }

    public List<Lotto> getLotto() {
        return List.copyOf(lotto);
    }

    public List<Rank> getTicketsResult(Lotto winningLotto, int bonus) {
        return lotto.stream()
                .map(ticket -> ticket.check(winningLotto, bonus))
                .toList();
    }

    private static List<Lotto> generateTicketList(int count) {
        List<Lotto> ticketList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            ticketList.add(
                    new Lotto(LottoNumberGenerator.generateWinningNumbers())
            );
        }

        return ticketList;
    }
}
