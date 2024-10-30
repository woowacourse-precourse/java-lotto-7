package lotto.fake;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.NumberGenerator;

public class FakeNumberGenerator extends NumberGenerator {

    public List<Integer> numbers;

    @Override
    public List<Integer> generate() {
        return this.numbers;
    }

}
