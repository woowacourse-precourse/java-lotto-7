package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import java.util.List;
import java.util.stream.Stream;

public class LottoGenerator {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int LOTTO_SIZE = 6;

    public static Lotto getLotto() {
        return new Lotto(generator());
    }

    public static List<Lotto> getLottos(int count) {
        return Stream.generate(LottoGenerator::getLotto)
                .limit(count)
                .toList();
    }

    private static List<Integer> generator() {
        return Randoms.pickUniqueNumbersInRange(MIN, MAX, LOTTO_SIZE);
    }
}
