package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Limit;

import java.util.List;

public class LottoNumberGenerator {
    private LottoNumberGenerator() {}

    public static LottoNumberGenerator create() {
        return new LottoNumberGenerator();
    }

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(Limit.MIN_RANGE, Limit.MAX_RANGE, Limit.LOTTO_SIZE);
    }
}
