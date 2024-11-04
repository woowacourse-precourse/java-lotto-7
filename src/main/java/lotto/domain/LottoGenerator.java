package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 45;
    private final int COUNT = 6;
    public Lotto generate() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT));
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

}
