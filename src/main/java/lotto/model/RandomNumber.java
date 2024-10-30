package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.util.Sorter;

public class RandomNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int GENERATE_COUNT = 6;

    public List<Integer> generate() {
        return Sorter.sort(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, GENERATE_COUNT));
    }
}
