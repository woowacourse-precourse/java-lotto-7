package lotto.model.lotto;

import lotto.number_generator.NumberGenerator;

import java.util.List;

public class LottoMachine {

    private final NumberGenerator numberGenerator;

    public LottoMachine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Integer> createLottoNumbers() {
        return numberGenerator.generate();
    }

    }
}
