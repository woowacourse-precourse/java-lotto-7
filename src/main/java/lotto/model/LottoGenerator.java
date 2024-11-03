package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final NumberGenerator numberGenerator;

    public LottoGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lotto generate() {
        return new Lotto(numberGenerator.generate());
    }
}
