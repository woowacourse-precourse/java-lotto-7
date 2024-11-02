package lotto.model.lotto;

import lotto.number_generator.NumberGenerator;

import java.util.List;

public class LottoGenerator {

    private final NumberGenerator numberGenerator;

    public LottoGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Integer> createNumbers() {
        return numberGenerator.generate();
    }

    public Lotto generate(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
