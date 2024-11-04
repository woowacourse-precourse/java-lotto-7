package lotto.global.util;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.lotto.Lotto;
import lotto.global.contents.LottoDetail;

public class LottoMachine {

    public static List<Lotto> generate(int count) {
        return IntStream.range(0, count)
                .mapToObj(lotto -> generateLotto())
                .toList();
    }

    private static Lotto generateLotto() {
        return Lotto.of(
                RandomValue.generate(
                        LottoDetail.MIN_VALUE,
                        LottoDetail.MAX_VALUE,
                        LottoDetail.NUMBER_COUNT)
        );
    }
}
