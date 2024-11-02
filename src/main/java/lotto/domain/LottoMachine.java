package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    public Lotto generateLotto() {
        List<Integer> randomNumbers =
                Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBERS_SIZE);
        return new Lotto(randomNumbers);
    }
}
