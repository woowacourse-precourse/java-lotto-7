package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.model.Lotto;

public class RandomNumbersGenerator {
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(Lotto.LOTTO_NUMBER_MIN, Lotto.LOTTO_NUMBER_MAX, Lotto.LOTTO_SIZE);
    }
}
