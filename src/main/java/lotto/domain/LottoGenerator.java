package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.Lotto;

import java.util.List;
import java.util.stream.Stream;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_COUNT = 6;

    private LottoGenerator() {}

    private static class LottoGeneratorHolder {
        private static final LottoGenerator INSTANCE = new LottoGenerator();
    }

    public static LottoGenerator getInstance() {
        return LottoGeneratorHolder.INSTANCE;
    }

    public List<Lotto> generateLottos(int count) {
        return Stream.generate(this::generateLotto)
                .limit(count)
                .toList();
    }

    private Lotto generateLotto() {
        return new Lotto(generateLottoNumbers());
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LottoGenerator.LOTTO_COUNT);
    }
}
