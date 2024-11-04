package lotto.domain;

import static lotto.common.LottoConstant.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import lotto.common.RandomNumbersCreator;

public class LottoFactory {

    public List<Lotto> createByCount(int count) {
        return IntStream.range(0, count).mapToObj(index -> {
            List<Integer> randomNumbers = RandomNumbersCreator.create(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER,
                    LOTTO_NUMBER_COUNT);
            Collections.sort(randomNumbers);
            return Lotto.create(randomNumbers);
        }).toList();
    }
}
