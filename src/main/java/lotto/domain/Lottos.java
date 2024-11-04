package lotto.domain;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.generator.NumberGenerator;

public class Lottos {

    private final Set<Lotto> lottos;

    private Lottos(Set<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(BigDecimal purchaseQuantity, NumberGenerator generator) {
        return new Lottos(
                IntStream.range(0, purchaseQuantity.intValue())
                         .mapToObj(i -> new Lotto(generator.generateNumber()))
                         .collect(Collectors.toSet())
        );
    }

    public Set<Lotto> getLottos() {
        return lottos;
    }
}
