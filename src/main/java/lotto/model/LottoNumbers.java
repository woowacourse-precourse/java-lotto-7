package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumbers {
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(RANGE_START, RANGE_END, LOTTO_NUMBER_COUNT)
                .stream()
                .sorted()
                .toList();
    }
}