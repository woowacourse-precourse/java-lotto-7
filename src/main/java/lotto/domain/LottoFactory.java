package lotto.domain;

import static lotto.common.LottoConstant.*;

import java.util.List;
import java.util.stream.IntStream;
import lotto.common.RandomNumbersCreator;

public class LottoFactory {

    public List<Lotto> createByCount(int count) {
        return IntStream.range(0, count)
                .mapToObj(index -> Lotto.create(
                        RandomNumbersCreator.create(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT)))
                .toList();
    }
}
