package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator implements NumberGenerator<Integer> {

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;
    public static final int COUNT = 6;

    @Override
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
    }
}
