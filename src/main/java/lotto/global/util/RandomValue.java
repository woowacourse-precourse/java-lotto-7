package lotto.global.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.global.contents.LottoDetail;

public class RandomValue {

    public static List<Integer> generate(LottoDetail start,
                                         LottoDetail end,
                                         LottoDetail count) {
        return Randoms.pickUniqueNumbersInRange(
                start.getValue(),
                end.getValue(),
                count.getValue()
        );
    }
}
