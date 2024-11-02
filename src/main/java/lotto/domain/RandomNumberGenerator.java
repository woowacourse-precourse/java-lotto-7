package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {

    public List<Integer> generate(int startInclusive, int endInclusive, int count) {
        try{
            return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] " + e.getMessage());
        }
    }
}
