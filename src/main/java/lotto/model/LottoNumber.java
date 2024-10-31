package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumber {
    private static final int START_VALUE = 1;
    private static final int END_VALUE = 45;
    private static final int NUMBER_COUNT = 6;

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(START_VALUE, END_VALUE, NUMBER_COUNT)
                .stream()
                .sorted()
                .toList();
    }
}
