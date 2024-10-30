package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomLotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int CNT_NUMBER = 6;

    public List<Integer> setRandNumbers() {
        List<Integer> randNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, CNT_NUMBER);
        Collections.sort(randNumbers);
        return new ArrayList<>(randNumbers);
    }
}
