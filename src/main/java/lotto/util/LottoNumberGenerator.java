package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator{
    public static List<Integer> generateLottoNumbers(int startInclusive, int endInclusive, int numberCount) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, numberCount);
    }

}