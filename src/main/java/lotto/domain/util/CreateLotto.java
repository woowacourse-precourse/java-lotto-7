package lotto.domain.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateLotto {

    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 45;
    private static final int LOTTO_COUNT = 6;

    private CreateLotto() {}

    public static List<Integer> lotto() {
        List<Integer> lottoNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(RANGE_MIN, RANGE_MAX, LOTTO_COUNT));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
