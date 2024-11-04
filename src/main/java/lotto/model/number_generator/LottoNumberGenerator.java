package lotto.model.number_generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.lotto.Lotto;

import java.util.List;

public class LottoNumberGenerator implements NumberGenerator{

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, Lotto.NUMBER_COUNT);
    }
}
