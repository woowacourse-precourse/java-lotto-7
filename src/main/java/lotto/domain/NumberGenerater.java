package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class NumberGenerater {
    private int returnNumberCount;

    public NumberGenerater(int returnNumberCount) {
        this.returnNumberCount = returnNumberCount;
    }

    public List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, this.returnNumberCount);
    }
}
