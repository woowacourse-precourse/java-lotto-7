package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;
import lotto.util.RandomUtil;

public class Tickets {

    private List<Lotto> lottos;

    public Tickets(TicketCount count) {
        this.lottos = generateLottoTickets(count);
    }

    private List<Lotto> generateLottoTickets(TicketCount count) {
        return IntStream.range(0, count.getCount())
                .mapToObj(cnt -> new Lotto(RandomUtil.generateLottoNumbers()))
                .toList();
    }
}
