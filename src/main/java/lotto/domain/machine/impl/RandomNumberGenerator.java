package lotto.domain.machine.impl;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.machine.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
