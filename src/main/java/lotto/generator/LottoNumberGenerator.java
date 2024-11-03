package lotto.generator;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumberGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int COUNT_NUMBER = 6;

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, COUNT_NUMBER);
    }
}
