package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    public static Lotto generate() {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_NUMBER_SIZE));
    }
}
