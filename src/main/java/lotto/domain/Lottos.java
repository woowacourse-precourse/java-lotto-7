package lotto.domain;

import lotto.util.StringMaker;

import java.util.List;

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
            throw new IllegalArgumentException();
        }
    }

    public List<Lotto> getValue() {
        return lottos;
    }

    public Integer size() {
        return lottos.size();
    }

    public String toString() {
        return StringMaker.make(lottos);
    }
}
