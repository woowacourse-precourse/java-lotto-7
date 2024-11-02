package lotto.global.util;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.lotto.Lotto;

public class LottoMachine {

    public static List<Lotto> generate(int count) {
        return IntStream.range(0, count)
                .mapToObj(lotto -> generateLotto())
                .toList();
    }

    private static Lotto generateLotto() {
        return Lotto.of(RandomValue.generate(1, 45, 6));
    }
}
