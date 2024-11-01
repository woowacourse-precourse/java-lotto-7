package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoRules {
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    public static List<Integer> pickRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_SIZE);
    }
}
