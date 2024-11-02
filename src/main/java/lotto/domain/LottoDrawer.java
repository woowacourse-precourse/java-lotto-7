package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoDrawer {
    public List<Integer> drawRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}
