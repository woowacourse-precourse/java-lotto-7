package lotto.model;

import java.util.ArrayList;
import java.util.List;

import lotto.util.generator.NumberGenerator;

public class LottoMachine {
    private final NumberGenerator<List<Integer>> numberGenerator;

    public LottoMachine(NumberGenerator<List<Integer>> numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> createLotto(int count) {
        List<Lotto> lottos = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = numberGenerator.generate();
            lottos.add(new Lotto(numbers));
        }
        return List.copyOf(lottos);
    }

    public Lotto createWinningLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}