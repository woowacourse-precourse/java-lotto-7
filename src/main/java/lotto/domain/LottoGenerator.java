package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.Lotto;

public class LottoGenerator {
    public static final int NUMBER_OF_NUMBERS = 6;
    public static final int RANDOM_MIN = 1;
    public static final int RANDOM_MAX = 45;

    private final Lotto lotto;

    public LottoGenerator() {
        this.lotto = new Lotto(generateNumbers());
    }

    private static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(RANDOM_MIN, RANDOM_MAX, NUMBER_OF_NUMBERS);
    }

    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }
}

