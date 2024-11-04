package lotto.domain.machine.generator;

import lotto.domain.lotto.Lotto;

public class LottoGenerator {

    private final NumberGenerator numberGenerator;

    public LottoGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lotto issueLotto() {
        return Lotto.from(numberGenerator.generate()
                .stream()
                .sorted()
                .toList()
        );
    }

}
