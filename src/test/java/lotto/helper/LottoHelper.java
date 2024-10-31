package lotto.helper;

import java.util.List;
import lotto.model.lotto.Lotto;

public class LottoHelper {

    private LottoHelper() {
    }

    public static Lotto mock(
            Integer source1,
            Integer source2,
            Integer source3,
            Integer source4,
            Integer source5,
            Integer source6
    ) {
        List<Integer> numbers = List.of(source1, source2, source3, source4, source5, source6);
        return Lotto.from(numbers);
    }
}
