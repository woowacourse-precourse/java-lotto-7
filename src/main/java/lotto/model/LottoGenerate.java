package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerate {
    public List<Integer> generate() {

        return new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
