package lotto.model.generator;

import java.util.List;

public class FixedNumberGenerator implements NumberGenerator {

    private final List<Integer> fixedNumbers;

    public FixedNumberGenerator(List<Integer> fixedNumbers) {
        this.fixedNumbers = fixedNumbers;
    }

    @Override
    public List<Integer> generateLottoNumbers() {
        return fixedNumbers;
    }
}