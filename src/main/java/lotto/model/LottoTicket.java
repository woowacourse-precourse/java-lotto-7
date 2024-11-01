package lotto.model;

import java.util.List;
import java.util.Objects;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoTicket that)) {
            return false;
        }
        return Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottos);
    }

    @Override
    public String toString() {
        return lottos.stream().map(Lotto::toString).collect(Collectors.joining("\n"));
    }
}
