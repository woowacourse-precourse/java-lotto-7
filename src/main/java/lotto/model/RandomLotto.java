package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomLotto {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int CNT_NUMBER = 6;

    public List<Integer> getRandNumbers() {
        List<Integer> randNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, CNT_NUMBER);
        List<Integer> sortedNumbers = new ArrayList<>(randNumbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }
}
