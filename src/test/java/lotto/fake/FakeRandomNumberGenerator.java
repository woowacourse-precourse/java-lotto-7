package lotto.fake;

import java.util.List;
import lotto.domain.machine.impl.RandomNumberGenerator;

public class FakeRandomNumberGenerator extends RandomNumberGenerator {

    public List<Integer> numbers;

    @Override
    public List<Integer> generate() {
        return this.numbers;
    }

}
