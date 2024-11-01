package lotto.util;

import lotto.domain.Lotto;
import lotto.policy.LottoNumberPolicy;

import java.util.List;
import java.util.stream.IntStream;

import static lotto.policy.LottoNumberPolicy.*;

public abstract class LottoListGenerator {

    public static List<Lotto> generateLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(SORTED_RANDOM_NUMBERS.getNumbers()))
                .toList();
    }
}
