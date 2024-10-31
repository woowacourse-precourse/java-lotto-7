package lotto.domain.machine.impl;

import java.util.List;
import lotto.domain.machine.NumberGenerator;

public class SimpleNumberGenerator implements NumberGenerator {

    private List<Integer> numbers;

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generate() {
        return this.numbers;
    }

}
