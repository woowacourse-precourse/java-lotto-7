package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_SIZE = 6;
    private final NumberGenerator numberGenerator;

    public LottoGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lotto generate() {
        return new Lotto(numberGenerator.generate());
    }
}
