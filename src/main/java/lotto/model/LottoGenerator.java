package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                Lotto.LOTTO_NUMBER_MIN,
                Lotto.LOTTO_NUMBER_MAX,
                Lotto.LOTTO_SIZE
        );
        return new Lotto(numbers);
    }
}
