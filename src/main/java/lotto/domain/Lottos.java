package lotto.domain;

import java.util.List;

public record Lottos(
        List<Lotto> lottos
) {

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }
}
