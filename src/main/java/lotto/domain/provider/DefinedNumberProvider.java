package lotto.domain.provider;

import java.util.Arrays;
import java.util.List;

public class DefinedNumberProvider implements NumberProvider {

    private final List<Integer> numbers;

    public DefinedNumberProvider(Integer...numbers) {
        this.numbers = Arrays.asList(numbers);
    }

    public DefinedNumberProvider(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> provide() {
        return numbers;
    }

}
