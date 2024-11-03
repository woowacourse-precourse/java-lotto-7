package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.global.util.NumberGenerator;

public class LottoNumberGenerator implements NumberGenerator {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_SIZE = 6;

    private LottoNumberGenerator() {
    }

    public static LottoNumberGenerator create() {
        return new LottoNumberGenerator();
    }

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_SIZE);
    }

}
