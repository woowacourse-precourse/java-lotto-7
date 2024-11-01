package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
            this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

    @Override
    public String toString() {
        return lottos.stream().map(Lotto::toString).collect(Collectors.joining("\n"));
    }
}
