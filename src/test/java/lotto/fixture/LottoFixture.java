package lotto.fixture;

import java.util.List;
import lotto.model.lotto.Lotto;

public class LottoFixture {

    private LottoFixture() {
    }

    public static Lotto create(Integer input1, Integer input2, Integer input3, Integer input4, Integer input5,
                               Integer input6) {
        List<Integer> numbers = List.of(input1, input2, input3, input4, input5, input6);
        return Lotto.from(numbers);
    }
}
