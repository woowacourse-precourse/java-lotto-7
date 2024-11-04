package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumbersGenerator {
    private static final Integer MIN_VALUE = 1;
    private static final Integer MAX_VALUE = 45;
    private static final Integer LOTTO_COUNT = 6;

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, LOTTO_COUNT);
    }
}
