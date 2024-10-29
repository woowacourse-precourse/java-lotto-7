package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.utils.NumberGenerator;

public class LottoNumberGenerator implements NumberGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT);
    }
}
