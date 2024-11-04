package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbersGenerator implements NumbersGenerator {

    @Override
    public List<Integer> generateNumbers(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }
}
