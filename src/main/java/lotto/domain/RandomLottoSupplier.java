package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoSupplier {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int COUNT_OF_NUMBER = 6;

    public Lotto supply() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, COUNT_OF_NUMBER);
        return new Lotto(numbers);
    }
}
