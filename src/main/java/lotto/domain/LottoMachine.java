package lotto.domain;

import java.util.List;

import lotto.domain.utils.NumbersGenerator;

public class LottoMachine {
    private final NumbersGenerator numbersGenerator;

    public LottoMachine(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public Lotto generate() {
        return new Lotto(generateNumbers());
    }

    private List<Integer> generateNumbers() {
        return numbersGenerator.generate();
    }
}
