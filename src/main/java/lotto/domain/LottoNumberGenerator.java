package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public final class LottoNumberGenerator {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int BONUS_SIZE = 1;

    private LottoNumberGenerator() {}

    static List<Integer> generateWinningNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBERS_SIZE);
    }

    static List<Integer> generateBonusNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, BONUS_SIZE);
    }
}
