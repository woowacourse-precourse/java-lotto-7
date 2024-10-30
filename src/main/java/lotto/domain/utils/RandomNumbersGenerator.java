package lotto.domain.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbersGenerator implements NumbersGenerator {
    static final int MIN = 1;
    static final int MAX = 45;
    static final int SIZE = 6;

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN, MAX, SIZE);
    }
}
