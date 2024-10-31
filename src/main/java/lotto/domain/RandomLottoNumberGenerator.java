package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoNumberGenerator {

    private static final int START = 1;
    private static final int END = 45;
    private static final int LENGTH = 6;

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(START, END, LENGTH);
    }
}
