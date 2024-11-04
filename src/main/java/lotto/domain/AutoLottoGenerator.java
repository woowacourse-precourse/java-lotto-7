package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Stream;

public class AutoLottoGenerator implements LottoGenerator {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    @Override
    public List<Lotto> generate(int count) {
        return Stream.generate(this::generateAutoLotto)
                .limit(count)
                .toList();
    }

    private Lotto generateAutoLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER,
                LOTTO_NUMBER_COUNT).stream()
                .sorted()
                .toList();

        return new Lotto(randomNumbers);
    }
}
