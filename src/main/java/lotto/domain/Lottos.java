package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.generator.RandomNumbersGenerator;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int lottoCount) {
        this.lottos = generateLottos(lottoCount);
    }

    private List<Lotto> generateLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = RandomNumbersGenerator.generateNumbers();
            lottos.add(new Lotto(randomNumbers));
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
