package lotto.domain.machine.generator.impl;

import java.util.List;
import lotto.domain.machine.generator.NumberGenerator;

public class SimpleNumberGenerator implements NumberGenerator {

    private final List<Integer> numbers;

    public SimpleNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generate() {
        return this.numbers;
    }

}
