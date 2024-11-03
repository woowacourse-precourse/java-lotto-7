package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerate {
    public List<Integer> generate() {
        List<Integer> lotto = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(1, 45, 6));

        Collections.sort(lotto);
        return lotto;
    }
}
