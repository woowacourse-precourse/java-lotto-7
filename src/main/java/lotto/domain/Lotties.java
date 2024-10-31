package lotto.domain;

import java.util.List;

public class Lotties {
    private final List<Lotto> lotties;

    public Lotties(List<Lotto> lotties) {
        validate(lotties);
        this.lotties = lotties;
    }

    public List<Lotto> getLotties() {
        return lotties;
    }

    private void validate(List<Lotto> lotties) {
        validateEmpty(lotties);
    }

    private void validateEmpty(List<Lotto> lotties) {
        if (lotties.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
