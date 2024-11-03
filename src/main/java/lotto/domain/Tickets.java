package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.RandomUtil;

public class Tickets {

    private final List<Lotto> lottos;

    public Tickets(TicketCount count) {
        this.lottos = generateLottoTickets(count);
    }

    public List<String> getTicketsInfo() {
        return lottos.stream()
                .map(Lotto::createNumberInfo)
                .toList();
    }

    public int getSize() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private List<Lotto> generateLottoTickets(TicketCount count) {
        Set<Lotto> uniqueLottos = new HashSet<>();

        while (uniqueLottos.size() < count.getCount()) {
            uniqueLottos.add(new Lotto(RandomUtil.generateLottoNumbers()));
        }

        return new ArrayList<>(uniqueLottos);
    }
}
