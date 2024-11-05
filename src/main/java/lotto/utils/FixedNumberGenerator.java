package lotto.utils;

import java.util.List;

public class FixedNumberGenerator implements LottoNumberGenerator {
    private final List<Integer> fixedNumber;

    public FixedNumberGenerator(List<Integer> fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public List<Integer> generate() {
        return fixedNumber;
    }


}
