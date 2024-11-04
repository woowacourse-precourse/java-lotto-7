package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return "\n" + lottos.size() + "개를 구매했습니다.\n" +
                lottos.stream()
                        .map(Lotto::toString)
                        .collect(Collectors.joining("\n"));
    }
}
