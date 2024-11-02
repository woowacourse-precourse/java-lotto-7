package lotto.lotto;

import java.util.Arrays;
import java.util.List;

public class StubLottoGenerator implements NumberGenerator {

    @Override
    public List<Integer> generate() {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }
}
