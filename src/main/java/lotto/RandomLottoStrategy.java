package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoStrategy implements LottoGenerateStrategy {
    @Override
    public List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
