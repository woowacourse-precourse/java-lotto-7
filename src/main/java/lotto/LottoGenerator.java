package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public List<Integer> drawLots() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
