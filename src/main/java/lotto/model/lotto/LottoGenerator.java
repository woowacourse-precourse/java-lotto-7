package lotto.model.lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT)
                .stream()
                .sorted()
                .toList();
    }
}
