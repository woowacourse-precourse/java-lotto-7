package lotto.domain;

import java.util.List;

import static lotto.enums.Error.INVALID_LOTTOS;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        validate(lottos);
        return new Lottos(lottos);
    }

    private static void validate(List<Lotto> lottos) {
        isNotEmpty(lottos);
    }

    private static void isNotEmpty(List<Lotto> lottos) {
        if(lottos.isEmpty()) {
            throw new IllegalArgumentException(INVALID_LOTTOS.getMessage());
        }
    }

    public List<Lotto> getValue() {
        return lottos;
    }

    public Integer size() {
        return lottos.size();
    }
}
