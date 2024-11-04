package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private static final String PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.\n";
    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return "\n" + lottos.size() + PURCHASE_COUNT_MESSAGE +
                lottos.stream()
                        .map(Lotto::toString)
                        .collect(Collectors.joining("\n"));
    }
}
