package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator implements NumberGenerate {

    public static final int LOTTO_NUM_START = 1;
    public static final int LOTTO_NUM_END = 45;
    public static final int LOTTO_NUM_SIZE = 6;

    @Override
    public List<Integer> randomGenerateInRange() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUM_START, LOTTO_NUM_END, LOTTO_NUM_SIZE);
    }
}
