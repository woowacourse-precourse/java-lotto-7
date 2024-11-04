package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int START_INDEX = 0;
    private final NumberGenerator numberGenerator;

    public LottoGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> generate(int numberOfLotto) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = START_INDEX; i < numberOfLotto; i++) {
            lottos.add(new Lotto(numberGenerator.generate()));
        }
        return lottos;
    }
}
