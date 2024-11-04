package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public List<Integer> drawLots() {
        return Randoms.pickUniqueNumbersInRange(NumberConstant.START, NumberConstant.END, NumberConstant.COUNT);
    }
}
