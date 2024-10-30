package lotto.domain.numbergenerator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class IntegersGenerator implements NumbersGenerator<Integer> {
    @Override
    public List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count) {

        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}
