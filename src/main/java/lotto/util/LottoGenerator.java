package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.Constant;
import lotto.domain.Lotto;
import java.util.List;
import java.util.stream.Stream;

public class LottoGenerator {

    public static Lotto getLotto() {
        return new Lotto(generator());
    }

    public static List<Lotto> getLottos(int count) {
        return Stream.generate(LottoGenerator::getLotto)
                .limit(count)
                .toList();
    }

    private static List<Integer> generator() {
        return Randoms.pickUniqueNumbersInRange(Constant.MIN, Constant.MAX, Constant.LOTTO_SIZE);
    }
}
