package lotto.domain.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public final class LottoNumberGenerator {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBERS_SIZE = 6;

    private LottoNumberGenerator() {}

    public static List<Integer> generateWinningNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBERS_SIZE);
    }

}
