package lotto.model.numbergenerator;

import static lotto.util.Constant.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_NUM_COUNT);
    }
}
