package lotto.domain;

import java.util.List;

public record Lottos(
        List<Lotto> value
) {

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }
}
