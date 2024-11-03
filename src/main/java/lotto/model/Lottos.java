package lotto.model;

import java.util.List;
import java.util.stream.IntStream;
import lotto.util.GenerateNumbers;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(int attemptCount, GenerateNumbers generateNumbers) {
        this.lottos = generateLottos(attemptCount, generateNumbers);
    }

    public static Lottos of(int attemptCount, GenerateNumbers generateNumbers) {
        return new Lottos(attemptCount, generateNumbers);
    }

    private List<Lotto> generateLottos(int attemptCount, GenerateNumbers generateNumbers) {
        return IntStream.range(0, attemptCount)
                .mapToObj(i -> generateLotto(generateNumbers))
                .toList();
    }

    private Lotto generateLotto(GenerateNumbers generateNumbers) {
        return new Lotto(generateNumbers.generateNumbers());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
