package lotto.model.lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final String DELIMITER = "\n";

    private final List<Lotto> lottos;

    private LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTicket of(List<Lotto> lottos) {
        return new LottoTicket(lottos);
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(
                        Collectors.joining(DELIMITER)
                );
    }

}
