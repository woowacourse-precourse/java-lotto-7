package lotto;

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
