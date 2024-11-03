package lotto.external;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.NumbersGenerator;

public class RandomNumbersGenerator implements NumbersGenerator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
