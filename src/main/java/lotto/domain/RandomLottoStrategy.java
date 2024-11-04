package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoStrategy implements LottoGenerateStrategy {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int REQUIRED_LOTTO_NUMBER_COUNT = 6;

    @Override
    public List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, REQUIRED_LOTTO_NUMBER_COUNT);
    }
}
