package lotto.basic;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumbersGenerator {
    public List<Integer> random(int start, int end, int size) {
        return Randoms.pickUniqueNumbersInRange(start, end, size);
    }
}
