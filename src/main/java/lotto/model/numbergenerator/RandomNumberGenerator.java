package lotto.model.numbergenerator;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
