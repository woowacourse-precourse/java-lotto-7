package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbersGenerator {
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(Lotto.LOTTO_NUMBER_MIN, Lotto.LOTTO_NUMBER_MAX, Lotto.LOTTO_SIZE);
    }
}
