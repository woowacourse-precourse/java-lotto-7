package lotto.provider;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberProvider implements NumberProvider{
    @Override
    public List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
    }
}
