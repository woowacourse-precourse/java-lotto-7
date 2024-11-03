package lotto.util;

import lotto.domain.Lotto;

import java.util.List;
import java.util.stream.IntStream;

import static lotto.policy.LottoNumberPolicy.RANDOM_NUMBERS;

public abstract class LottoListGenerator {

    public static List<Lotto> generateLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(RANDOM_NUMBERS.getNumbers()))
                .toList();
    }
}
