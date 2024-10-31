package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public final class LottoGenerator {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private LottoGenerator() {
    }

    public static List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
    }
}