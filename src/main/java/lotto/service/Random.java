package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Random {

    public List<Integer> NumberIssue(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}
