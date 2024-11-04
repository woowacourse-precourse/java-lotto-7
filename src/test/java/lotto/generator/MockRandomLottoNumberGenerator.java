package lotto.generator;

import java.util.List;

public class MockRandomLottoNumberGenerator implements RandomValueGenerator {
    private final List<Integer> fixedNumbers;

    public MockRandomLottoNumberGenerator(List<Integer> fixedNumbers) {
        this.fixedNumbers = fixedNumbers;
    }

    @Override
    public List<Integer> generate() {
        return fixedNumbers;
    }
}
