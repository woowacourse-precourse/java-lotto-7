package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;

public class RandomGenerator implements Generator {
    @Override
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(Lotto.LOTTO_NUMBER_MIN, Lotto.LOTTO_NUMBER_MAX, Lotto.LOTTO_SIZE);
    }
}
