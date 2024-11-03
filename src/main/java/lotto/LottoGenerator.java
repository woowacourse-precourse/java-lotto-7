package lotto;

import camp.nextstep.edu.missionutils.Randoms;

public final class LottoGenerator {

    private LottoGenerator() {
    }

    public static Lotto generate() {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(1, 45, 6)
        );
    }
}
