package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoGenerator implements NumberGenerate {

    public static final int LOTTO_RANGE = 6;

    @Override
    public List<Integer> randomGenerateInRange(int start, int end) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(start, end, LOTTO_RANGE);
        Collections.sort(numbers);
        return numbers;
    }
}
