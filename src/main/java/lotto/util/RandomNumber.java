package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public final class RandomNumber {

    private RandomNumber() {}

    public static List<Integer> getUniqueNumbers(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }

}
