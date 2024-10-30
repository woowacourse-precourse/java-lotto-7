package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import lotto.global.util.RandomValue;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(int count) {
        this.lottos = generate(count);
    }

    public static Lottos from(int count) {
        return new Lottos(count);
    }

    private List<Lotto> generate(int count) {
        return IntStream.range(0, count)
                .mapToObj(lotto -> generateLotto())
                .toList();
    }

    private Lotto generateLotto() {
        return Lotto.of(RandomValue.generate(1, 45, 6));
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
