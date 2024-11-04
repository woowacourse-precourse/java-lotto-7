package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    public List<Lotto> generateLottos(int count) {
        return Stream.generate(this::generateLotto)
                .limit(count)
                .toList();
    }

    private Lotto generateLotto() {
        List<String> numbers = generateLottoNumbers()
                .stream()
                .map(Objects::toString)
                .toList();

        return new Lotto(numbers);
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, 6);
    }
}
