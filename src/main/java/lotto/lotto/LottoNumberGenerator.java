package lotto.lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumberGenerator implements NumberGenerator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_COUNT);
    }
}
