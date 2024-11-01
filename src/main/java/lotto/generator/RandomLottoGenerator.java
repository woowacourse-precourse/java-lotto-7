package lotto.generator;

import static lotto.constant.LottoConstants.LOTTO_RANGE_MAX;
import static lotto.constant.LottoConstants.LOTTO_RANGE_MIN;
import static lotto.constant.LottoConstants.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {
    private RandomLottoGenerator() {
    }

    private static class BillPughSingleton {
        private static final RandomLottoGenerator INSTANCE = new RandomLottoGenerator();
    }

    public static RandomLottoGenerator getInstance() {
        return BillPughSingleton.INSTANCE;
    }

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_MIN, LOTTO_RANGE_MAX, LOTTO_SIZE);
    }
}
