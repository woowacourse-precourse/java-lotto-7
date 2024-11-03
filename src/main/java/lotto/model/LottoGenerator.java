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
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_SIZE; i++) {
            lottoNumbers.add(numberGenerator.generate());
        }
        return new Lotto(lottoNumbers);
    }
}
