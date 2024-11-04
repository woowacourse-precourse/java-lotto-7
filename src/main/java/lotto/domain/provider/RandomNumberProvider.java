package lotto.domain.provider;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberProvider implements NumberProvider {

    @Override
    public List<Integer> provide() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
