package lotto.application.ticket.domain.ticket;

import static java.util.Collections.unmodifiableList;
import static lotto.application.ticket.message.Message.CANT_EMPTY_LOTTO;
import static lotto.application.ticket.message.Message.CANT_NULL_LOTTO;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = unmodifiableList(lottos);
    }

    public static Lottos of(List<Lotto> lottos) {
        validate(lottos);
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public List<List<Integer>> getValue() {
        return lottos.stream()
                .map(lotto -> lotto.getNumbers())
                .collect(Collectors.toUnmodifiableList());
    }

    private static void validate(List<Lotto> lottos) {
        validateNotNull(lottos);
        validateNotEmpty(lottos);
    }

    private static void validateNotNull(List<Lotto> lottos) {
        if (lottos == null) {
            throw new IllegalArgumentException(CANT_NULL_LOTTO);
        }
    }

    private static void validateNotEmpty(List<Lotto> lottos) {
        if (lottos.isEmpty()) {
            throw new IllegalArgumentException(CANT_EMPTY_LOTTO);
        }
    }

}
