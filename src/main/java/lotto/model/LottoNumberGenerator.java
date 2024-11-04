package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {
    public List<Integer> getNumbers() {
        return List.copyOf(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
